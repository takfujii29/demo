//package jp.co.aivick.demo.entity;
//
//import org.seasar.doma.Column;
//import org.seasar.doma.Entity;
//import org.seasar.doma.GeneratedValue;
//import org.seasar.doma.GenerationType;
//import org.seasar.doma.Id;
//import org.seasar.doma.Table;
//
//@Entity
//@Table
//public class Menu {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "menu_id")
//	private Integer menuId;
//	
//	@Column(name = "menu_name")
//	private String menuName;
//	
//	@Column(name = "menu_type")
//	private String menuType;
//	
//	@Column(name = "price")
//	private Integer menuPrice;
//	
//	public void setMenuId(Integer menuId) {
//		this.menuId = menuId;
//	}
//	
//	public Integer getMuneId() {
//		return menuId;
//	}
//	
//	public void setMenuName(String menuName) {
//		this.menuName = menuName;
//	}
//	
//	public String getMenuName() {
//		return menuName;
//	}
//	
//	public void setMenuPrice(Integer menuPrice) {
//		this.menuPrice = menuPrice;
//	}
//	
//	public Integer getMenuPrice(Integer menuPrice) {
//		return menuPrice;
//	}
//}