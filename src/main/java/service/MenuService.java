package service;

import java.util.List;

import entity.Menu;

public interface MenuService {
	//获取所有的菜单
	public List<Menu> getAllMenu();
	//增加菜单
	public void addMenu(Menu menu);
	//根据id获取菜单
	public Menu getMenuById(int menu_id);
	//更新菜单
	public void updateMenu(Menu menu);
	//根据id删除菜单
	public void deleteMenu(int menu_id);
}
