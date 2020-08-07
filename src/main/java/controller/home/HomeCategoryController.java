package controller.home;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import entity.Article;
import entity.Article_Category_Ref;
import entity.Category;
import service.ArticleService;
import service.CategoryService;

@Controller
public class HomeCategoryController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CategoryService categoryService;
	
	//根据分类查询文章
	@RequestMapping("/home/articleListByCategory/{category_id}")
	public ModelAndView articleListByCategory(@RequestParam(required=false,defaultValue="0") Integer start,@RequestParam(required=false,defaultValue="10") int number,@PathVariable("category_id") Integer category_id) {
		//根据categoryId获取category
		Category category = categoryService.getCategoryById(category_id);
		//根据categoryId获取分页的文章
		Map<String,Object> map = articleService.getArticleByCategoryForPaging(start,number,category_id);
		//分页的文章
		List<Article> articleList = (List<Article>) map.get("articleList");
		//分页的数据
		PageInfo<Article_Category_Ref> pageInfo = (PageInfo<Article_Category_Ref>) map.get("pageInfo");
		//获取观看数最多的5条文章（热门文章）
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/articleListByCategory");
		mav.addObject("category",category);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("articleList",articleList);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
}
