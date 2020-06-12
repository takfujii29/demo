package jp.co.aivick.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.RecipeForm;
import jp.co.aivick.demo.form.RecipeSearchForm;
import jp.co.aivick.demo.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController{

	@Autowired
	RecipeService recipeService;

	@GetMapping("/list")
	public String list(Model model, RecipeSearchForm recipeSearchForm) {

		List<Recipe> recipes = recipeService.findAll();
		model.addAttribute("recipes", recipes);
		return "recipes/list.html";

	}

	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("recipeForm", new RecipeForm());
		return "recipes/create.html";
	}

	@PostMapping("/create")
	public String create(@Validated RecipeForm recipeForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "recipes/create.html";
		}

		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeForm.getRecipeName());
		recipe.setRecipeCal(recipeForm.getRecipeCal());
		Recipe createdRecipe = recipeService.create(recipe);

		return "redirect:/recipes/update/" + createdRecipe.getRecipeId();
	}
		
	@GetMapping("/search")
	public String search(RecipeSearchForm recipeSearchForm, Model model) {
		
		if(recipeSearchForm.getSearch() == null && recipeSearchForm.getSearchCal() == null) {
			return "recipes/list.html";
		}
		
		if(recipeSearchForm.getSearch() != null) {
			List<Recipe> recipeList = recipeService.search(recipeSearchForm.getSearch());
			model.addAttribute("recipeList", recipeList);
		}
		
		if(recipeSearchForm.getSearchCal() != null) {
			List<Recipe> recipeList = recipeService.searchCal(recipeSearchForm.getSearchCal());
			model.addAttribute("recipeList", recipeList);
		}
		return "recipes/search.html";
	}

    @GetMapping("/update/{recipeId}")
    public String showUpdate(@PathVariable("recipeId") String recipeId, Model model) {
        Recipe recipe = recipeService.findBy(recipeId);
        RecipeForm recipeForm = new RecipeForm();
        recipeForm.setRecipeId(recipe.getRecipeId());
        recipeForm.setRecipeName(recipe.getRecipeName());
        recipeForm.setRecipeCal(recipe.getRecipeCal());
        model.addAttribute("recipeForm", recipeForm);
        return "recipes/update.html";
    }

	@PostMapping("/update/{recipeId}")
	public String update(@PathVariable("recipeId") String recipeId, @Validated RecipeForm recipeForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "recipes/update.html";
		}

		Recipe recipe = recipeService.findBy(recipeId);
		recipe.setRecipeName(recipeForm.getRecipeName());
		recipe.setRecipeCal(recipeForm.getRecipeCal());
		Recipe updateRecipe = recipeService.update(recipe);
		return "redirect:/recipes/update/" + updateRecipe.getRecipeId();

	}
}