package controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Link;
import service.LinkService;

@Controller
public class LinkController {
	
	@Autowired
	LinkService linkService;
	
	//后台添加连接
	@RequestMapping("/admin/link/insert")
	public ModelAndView linkInsertPage() {
		List<Link> linkList = linkService.getAllLink();
		ModelAndView mav= new ModelAndView("/admin/link/insert");
		mav.addObject(linkList);
		return mav;
	}
	
	//后台全部链接
	@RequestMapping("/admin/link/index")
	public ModelAndView LinkIndex() {
		List<Link> linkList = linkService.getAllLink();
		ModelAndView mav = new ModelAndView("/admin/link/index");
		mav.addObject(linkList);
		return mav;
	}
	
	//添加链接提交
	@RequestMapping("/admin/link/insertSubmit")
	public String linkInsertSubmit(Link link) {
		link.setLink_create_time(new Date());
		//若没有指定order的值则默认为0
		if(link.getLink_order() == null) {
			link.setLink_order(0);
		}
		linkService.insertLink(link);
		return "redirect:/admin/link/index";
	}
	
	//跳转到编辑链接页面
	@RequestMapping("/admin/link/edit/{id}")
	public ModelAndView linkEdit(@PathVariable("id") int link_id) {
		//获取需要修改的链接
		Link link = linkService.getLinkById(link_id);
		//获取全部连接
		List<Link> linkList = linkService.getAllLink();
		ModelAndView mav = new ModelAndView("/admin/link/edit");
		mav.addObject("link",link);
		mav.addObject("linkList",linkList);
		return mav;
	}
	
	//修改连接提交
	@RequestMapping("/admin/link/editSubmit")
	public String linkEditSubmit(Link link) {
		link.setLink_update_time(new Date());
		linkService.updateLink(link);
		return "redirect:/admin/link/index";
	}
	
	//根据id删除链接
	@RequestMapping("/admin/link/delete/{id}")
	public String linkDelete(@PathVariable("id") int link_id) {
		linkService.deleteLinkById(link_id);
		return "redirect:/admin/link/index";
	}
	
}
