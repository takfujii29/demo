package jp.co.aivick.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class MenuForm {
	
	private Integer menuId;
	
	@NotEmpty
	private String menuName;
	
	@NotEmpty
	@Pattern(regexp = "和食|洋食|中華")
	private String menuType;
	
	@Positive
	@NotNull
	private Integer menuPrice;
	
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	public Integer getMenuId() {
		return menuId;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	
	public String getMenuType() {
		return menuType;
	}
	
	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public Integer getMenuPrice() {
		return menuPrice;
	}

}
