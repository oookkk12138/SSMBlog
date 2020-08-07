package controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Article;
import entity.Page;
import service.ArticleService;
import service.PageService;

@Controller
public class PageController {
	
	@Autowired
	PageService pageService;
	
	@Autowired
	ArticleService articleService;
	
	//后台添加页面
	@RequestMapping("/admin/page/insert")
	public String insertPage() {
		return "/admin/page/insert";
	}
	
	//后台全部页面
	@RequestMapping("/admin/page/index")
	public ModelAndView pageIndex() {
		List<Page> pageList = pageService.getAllPage();
		ModelAndView mav = new ModelAndView("/admin/page/index");
		mav.addObject("pageList",pageList);
		return mav;
	}
	
	//跳转到后台编辑页面
	@RequestMapping("/admin/page/edit/{id}")
	public ModelAndView pageEdit(@PathVariable("id") int page_id) {
		Page page = pageService.getPageById(page_id);
		ModelAndView mav = new ModelAndView("/admin/page/edit");
		mav.addObject("page",page);
		return mav;
	}
	
	//页面编辑提交
	@RequestMapping("/admin/page/editSubmit")
	public String pageEditSubmit(Page page) {
		page.setPage_update_time(new Date());
		pageService.updatePage(page);
		return "redirect:/admin/page/index";
	}
	
	//删除页面
	@RequestMapping("/admin/page/delete/{id}")
	public String pageDelete(@PathVariable("id") Integer page_id) {
		pageService.deletePageById(page_id);
		return "redirect:/admin/page/index";
	}
	
	//添加页面提交
	@RequestMapping("/admin/page/insertSubmit")
	public String pageInsertSubmit(Page page) {
		page.setPage_create_time(new Date());
		pageService.addPage(page);
		return "redirect:/admin/page/index";
	}
	
	//跳转到展示页面(前台)
	@RequestMapping("/home/page/{id}")
	public ModelAndView goToPage(@PathVariable("id") int page_id) {
		//获取页面
		Page page = pageService.getPageById(page_id);
		//获取5个热门文章
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/page");
		mav.addObject("page",page);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
	
}
