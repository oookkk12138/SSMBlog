package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MenuDao;
import entity.Menu;
import service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuDao menuDao;
	
	//获取所有的菜单
	public List<Menu> getAllMenu() {
		List<Menu> menuList = menuDao.getAllMenu();
		return menuList;
	}

	//增加菜单
	public void addMenu(Menu menu) {
		menuDao.insertMenu(menu);
	}

	//根据id获取菜单
	public Menu getMenuById(int menu_id) {
		Menu menu = menuDao.getMenuById(menu_id);
		return menu;
	}

	//更新菜单
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}

	//根据id删除菜单
	public void deleteMenu(int menu_id) {
		menuDao.deleteMenu(menu_id);
	}

}
