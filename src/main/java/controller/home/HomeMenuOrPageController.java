package controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Article;
import entity.Category;
import entity.Tag;
import enums.ArticleEnum;
import service.ArticleService;
import service.CategoryService;
import service.TagService;

@Controller
public class HomeMenuOrPageController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TagService tagService;
	
	//申请友链
	@RequestMapping("/home/applyLink")
	public ModelAndView applyLink() {
		//获取5个热门文章
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/applyLink");
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
	
	//文章归档
	@RequestMapping("/home/articleFile")
	public ModelAndView articlefile() {
		//获取所有文章
		List<Article> articleList = articleService.getAllArticleByStatus(ArticleEnum.release);
		//获取5个热门文章
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/articleFile");
		mav.addObject("hotViewArticleList",hotViewArticleList);
		mav.addObject("articleList",articleList);
		return mav;
	}
	
	//站点地图
	@RequestMapping("/home/siteMap")
	public ModelAndView siteMap() {
		//文章列表
		List<Article> articleList = articleService.getAllArticleByStatus(ArticleEnum.release);
		//分类列表
		List<Category> categoryList = categoryService.getAllCategory();
		//标签库
		List<Tag> tagList = tagService.getAllTagWithArticle();
		//热门文章
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/siteMap");
		mav.addObject("articleList",articleList);
		mav.addObject("categoryList",categoryList);
		mav.addObject("tagList",tagList);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
	
	//留言板
	@RequestMapping("/home/message")
	public ModelAndView messagePage() {
		//热门文章
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/message");
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
	
}
