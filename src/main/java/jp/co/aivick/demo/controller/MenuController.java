package jp.co.aivick.demo.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.MenuForm;
import jp.co.aivick.demo.service.MenuService;
import jp.co.aivick.demo.service.RecipeService;


@Controller
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	@Autowired
	RecipeService recipeService;
	
	  /**
	   * selectの表示に使用するアイテム
	   */
	  final static Map<String, String> SELECT_ITEMS =
	    Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	    {
	      put("和食", "和食");
	      put("洋食", "洋食");
	      put("中華", "中華");
	    }
	  });
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Menu> menus = menuService.findAll();
		model.addAttribute("menus", menus);
		
		return "menus/list.html";
	}
	
	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("selectItems", SELECT_ITEMS);
		model.addAttribute("menuForm", new MenuForm());
		List<Recipe> recipeList = recipeService.findAll();
		model.addAttribute("recipeList", recipeList);
		return "menus/create.html";
	}
	
	@PostMapping("/create")
	public String create(@Validated MenuForm menuForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "menus/create.html";
		}
		Menu menu = new Menu(null, menuForm.getMenuName(), menuForm.getMenuType(), menuForm.getMenuPrice());
		menuService.create(menu, menuForm.getRecipeList());
		
		return "redirect:/";
	}

}
