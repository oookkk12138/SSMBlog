package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Menu;

@Repository
public interface MenuDao {
	//获取所有的菜单
	public List<Menu> getAllMenu();
	//添加菜单
	public void insertMenu(Menu menu);
	//根据id获取菜单
	public Menu getMenuById(int menu_id);
	//更新菜单
	public void updateMenu(Menu menu);
	//根据id删除菜单
	public void deleteMenu(int menu_id);
}
