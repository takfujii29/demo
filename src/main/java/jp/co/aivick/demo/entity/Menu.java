package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(immutable = true)
@Table(name = "menus")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	final private Integer menuId;
	
	@Column(name = "menu_name")
	final private String menuName;
	
	@Column(name = "menu_type")
	final private String menuType;
	
	@Column(name = "price")
	final private Integer menuPrice;
	
	public Menu(Integer menuId, String menuName, String menuType, Integer menuPrice) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuType = menuType;
		this.menuPrice = menuPrice;
	}

	public Integer getMenuId() {
		return menuId;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public String getMenuType() {
		return menuType;
	}
	
	public Integer getMenuPrice() {
		return menuPrice;
	}
}
