package controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import entity.Article;
import entity.Comment;
import entity.User;
import service.ArticleService;
import service.CommentService;
import service.UserService;

@Controller
public class HomeArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentService commentService;
	
	//根据id获取文章等相关信息并跳转到显示页面
	@RequestMapping("/home/article/{id}")
	public ModelAndView articleDetailPage(@PathVariable("id") Integer id) {
		//根据id获取文章
		Article article = articleService.getArticleByIdWithCategoryListAndTagList(id);
		ModelAndView mav = new ModelAndView();
		//若获取不到文章则跳转到404页面
		if(article == null) {
			mav.setViewName("/home/error/404");
		}
		//根据文章id获取用户
		User user = userService.getUserById(article.getArticle_id());
		//获取观看数最多的5条文章（热门文章）
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		//获取上一篇文章
		Article preArticle = articleService.getArticleById(id-1);
		//获取下一篇文章
		Article nextArticle = articleService.getArticleById(id+1);
		//根据文章id获取对应的评论集合
		List<Comment> commentList = commentService.getCommentByArticleId(id);
		mav.addObject("article",article);
		mav.addObject("user",user);
		mav.addObject("commentList",commentList);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		mav.addObject("preArticle",preArticle);
		mav.addObject("nextArticle",nextArticle);
		mav.setViewName("/home/page/articleDetail");
		return mav;
	}
	
	//搜索文章
	@RequestMapping("/home/article/search")
	public ModelAndView searchArticle(@RequestParam(required=false,defaultValue="0") int start,@RequestParam(required=false,defaultValue="10") int number,String keywords) {
		//根据keywords模糊查询出相应的文章
		PageInfo<Article> articleList = articleService.getArticleWithVagueTitleForPaging(keywords,start,number);
		//获取观看数最多的5条文章（热门文章）
		List<Article> hotViewArticleList = articleService.getFiveHotViewArticle();
		ModelAndView mav = new ModelAndView("/home/page/search");
		mav.addObject("pageInfo",articleList);
		mav.addObject("hotViewArticleList",hotViewArticleList);
		return mav;
	}
	
	//文章浏览量加一
	//(在script.js中使用了cookie，若用户cookie中已存在此文章，即已阅读过，则不调用此方法)
	@RequestMapping("/home/article/view/{id}")
	@ResponseBody
	public String articleView(@PathVariable("id") Integer article_id) {
		//根据id获取文章并修改文章的观看数
		Article article = articleService.getArticleById(article_id);
		int viewCount = article.getArticle_view_count();
		viewCount++;
		article.setArticle_view_count(viewCount);
		articleService.updateArticle(article);
		return String.valueOf(viewCount);
	}
	
	//点赞
	//(在script.js中使用了cookie，若用户cookie中已存在此文章，即已点赞过，则不调用此方法)
	@RequestMapping("/home/article/like/{id}")
	@ResponseBody
	public String artcleLike(@PathVariable("id") Integer article_id) {
		//根据id获取文章并修改文章的点赞数
		Article article = articleService.getArticleById(article_id);
		int likeCount = article.getArticle_like_count();
		likeCount++;
		article.setArticle_like_count(likeCount);
		articleService.updateArticle(article);
		return String.valueOf(likeCount);
	}
	
}
