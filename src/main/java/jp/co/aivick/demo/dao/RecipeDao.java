package jp.co.aivick.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.demo.entity.Recipe;

@ConfigAutowireable
@Dao
public interface RecipeDao {

	@Select
	Recipe find(String recipeId);

	@Select
	List<Recipe> findAll();
	
	@Select
 	List<Recipe> search(String search);
	
	@Select
	List<Recipe> searchCal(Double searchCal);
	
	@Insert
	int insert(Recipe recipe);

	@Update
	int update(Recipe recipe);

}
