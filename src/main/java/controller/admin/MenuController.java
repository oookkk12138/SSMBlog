package controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Menu;
import service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	//后台菜单页面
	@RequestMapping("/admin//menu/index")
	public ModelAndView settingMenu() {
		List<Menu> menuList = menuService.getAllMenu();
		ModelAndView mav = new ModelAndView("/admin/menu/index");
		mav.addObject("menuList",menuList);
		return mav;
	}
	
	//添加菜单提交
	@RequestMapping("/admin/menu/insertSubmit")
	public String menuInsertSubmit(Menu menu) {
		menu.setMenu_order(0);
		menuService.addMenu(menu);
		return "redirect:/admin//menu/index";
	}
	
	//跳转到修改菜单页面
	@RequestMapping("/admin/menu/edit/{id}")
	public ModelAndView menuEdit(@PathVariable("id") int menu_id) {
		Menu menu = menuService.getMenuById(menu_id);
		List<Menu> menuList = menuService.getAllMenu();
		ModelAndView mav = new ModelAndView("/admin/menu/edit");
		mav.addObject("menu",menu);
		mav.addObject("menuList",menuList);
		return mav;
	}
	
	//修改菜单提交
	@RequestMapping("/admin/menu/editSubmit")
	public String menuEditSubmit(Menu menu) {
		menuService.updateMenu(menu);
		return "redirect:/admin//menu/index";
	}
	
	//删除菜单
	@RequestMapping("/admin/menu/delete/{id}")
	public String menuDelete(@PathVariable("id") int menu_id) {
		menuService.deleteMenu(menu_id);
		return "redirect:/admin//menu/index";
	}
	
}
