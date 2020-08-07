package controller.home;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Article;
import entity.Comment;
import service.ArticleService;
import service.CommentService;
import util.MyUtils;

@Controller
public class HomeCommentController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CommentService commentService;
	
	//添加评论
	@RequestMapping("/home/addComment")
	@ResponseBody
	public String addComment(Comment comment,HttpServletRequest request) {
		//设置评论的ip和创建时间
		comment.setComment_ip(MyUtils.getIpAddress(request));
		comment.setComment_create_time(new Date());
		//如果是游客身份，即没有头像就把游客头像给他
		if(comment.getComment_author_avator() == null) {
			comment.setComment_author_avator("/SSMBlog/resource/img/visitor.jpg");
		}
		//添加评论
		commentService.addComment(comment);
		//修改文章中的评论数
		Article article = articleService.getArticleById(comment.getComment_article_id());
		int commentCount = article.getArticle_comment_count();
		commentCount++;
		article.setArticle_comment_count(commentCount);
		articleService.updateArticle(article);
		return "success";
	}
}
