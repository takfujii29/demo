package jp.co.aivick.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;

public class RecipeForm {

	private Integer recipeId;

	@NotEmpty
	private String recipeName;
	
	@Positive
	@NotNull
	private Double recipeCal;

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public void setRecipeCal(Double recipeCal) {
		this.recipeCal = recipeCal;
	}
	
	public Double getRecipeCal() {
		return recipeCal;
	}
}