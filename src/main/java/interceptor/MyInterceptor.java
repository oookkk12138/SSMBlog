package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import entity.Category;
import entity.Menu;
import entity.Option;
import entity.Tag;
import service.ArticleService;
import service.CategoryService;
import service.CommentService;
import service.LinkService;
import service.MenuService;
import service.OptionService;
import service.TagService;
import service.UserService;

public class MyInterceptor implements HandlerInterceptor{
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	LinkService linkService;
	
	@Autowired
	OptionService optionService;

	//这里适用拦截器，对每一个controller的请求进行公有的数据准备(拦截器适用了AOP思想)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取所有菜单信息
		List<Menu> staticMenuList = menuService.getAllMenu();
		//获取所有分类信息
		List<Category> staticCategoryList = categoryService.getAllCategory();
		//获取所有标签
		List<Tag> staticTagList = tagService.getAllTag();
		//获取网站需要的统计数据（用户总数、文章总数、分类总数、标签总数、评论总数、链接总数、浏览总量）
		int staticArticleCount = articleService.getArticleCount();
		int staticCategoryCount = categoryService.getCategoryCount();
		int staticCommentCount = commentService.getCommentCount();
		int staticUserCount = userService.getUserCount();
		int staticTagCount = tagService.getTagCount();
		int staticLinkCount = linkService.getLinkCount();
		int totalViewCount = articleService.getTotalViewCount();
		//博客基本信息显示
		Option staticOption = optionService.getOptionFirst();
		//保存到request中
		request.setAttribute("staticMenuList",staticMenuList);
		request.setAttribute("staticCategoryList",staticCategoryList);
		request.setAttribute("staticArticleCount",staticArticleCount);
		request.setAttribute("staticCategoryCount",staticCategoryCount);
		request.setAttribute("staticCommentCount",staticCommentCount);
		request.setAttribute("staticUserCount",staticUserCount);
		request.setAttribute("staticTagCount",staticTagCount);
		request.setAttribute("staticLinkCount",staticLinkCount);
		request.setAttribute("staticOption",staticOption);
		request.setAttribute("totalViewCount",totalViewCount);
		request.setAttribute("staticTagList",staticTagList);
		System.out.println("前置通知");
		return true;
	}
	
}
