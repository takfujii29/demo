package jp.co.aivick.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aivick.demo.dao.MenuDao;
import jp.co.aivick.demo.dao.MenuRecipeDao;
import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.MenuRecipe;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private MenuRecipeDao menuRecipeDao;
	
	public Menu findBy(String menuId) {
		return menuDao.find(menuId);
	}
	
	public List<Menu> findAll() {
		return this.menuDao.findAll();
	}
	
	@Transactional
	public Menu create(Menu menu, String[] recipes) {
		Result<Menu> menuResult = menuDao.insert(menu);
		Menu createdMenu = menuResult.getEntity();
		List<MenuRecipe> menuRecipe = IntStream.range(0, recipes.length)
				                                 .mapToObj(i -> {
				                                	 MenuRecipe m = new MenuRecipe();
				                                	m.setRecipeId(Integer.parseInt(recipes[i]));
				                                	 m.setMenuId(createdMenu.getMenuId());
				                                	 return m;
				                                 })
				                                 .collect(Collectors.toList());
		menuRecipeDao.insert(menuRecipe);
		return createdMenu;
	}
//	

}
