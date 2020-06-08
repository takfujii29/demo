package jp.co.aivick.demo.form;

public class RecipeSearchForm {
	
	
	private String search;
	
	private Double searchCal;

	public void setSearchCal(Double searchCal) {
		this.searchCal = searchCal;
	}
	
	public Double getSearchCal() {
		return searchCal;
	} 

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
