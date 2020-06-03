package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private Integer recipeId;

	@Column(name = "recipe_name")
	private String recipeName;
	
	@Column(name = "cal")
	private Double recipeCal;

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeName() {
		return recipeName;
	}
	
	public void setRecipeCal(Double recipeCal) {
		this.recipeCal = recipeCal;
	}
	
	public Double getRecipeCal() {
		return recipeCal;
	}


}
