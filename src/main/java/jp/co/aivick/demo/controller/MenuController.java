//package jp.co.aivick.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import jp.co.aivick.demo.entity.Menu;
//import jp.co.aivick.demo.form.MenuForm;
//import jp.co.aivick.demo.service.MenuService;
//
//@Controller
//@RequestMapping("/menus")
//public class MenuController {
//	
//	@Autowired
//	MenuService menuService;
//	
//	@GetMapping("/list")
//	public String list(Model model) {
//		
//		List<Menu> menus = menuService.findAll();
//		model.addAttribute("menus", menus);
//		
//		return "menus/list.html";
//	}
//	
//	@GetMapping("/create")
//	public String showCreate(Model model) {
//		model.addAttribute("menuForm", new MenuForm());
//		return "menus/create.html";
//	}
//	
////	@PostMapping("/create")
////	public String create(@Validated MenuForm menuForm, BindingResult bindingResult Model model) {
////		if(bindingResult.hasErrors()) {
////			return "menus/create.html";
////		}
////		
////		Menu menu = new Menu();
////		menu.setMenuName(menuForm.getMenuName());
////		menu.setMenuPrice(menuForm.getMenuPrice());
////		Menu createdMenu = menuService.create(menu);
////		
////		return "redirect:/menus/update/" + createdMenu.getMuneId();
////	}
//}
