package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.ArticleDao;
import dao.CommentDao;
import entity.Article;
import entity.Comment;
import service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;
	
	@Autowired
	ArticleDao articleDao;
	
	//获取最后的5条评论
	public List<Comment> getLastFiveComment() {
		PageHelper.offsetPage(0,5);
		List<Comment> commentList = commentDao.getAllCommentDesc();
		return commentList;
	}

	//倒序获取所有评论（封装文章）
	public PageInfo<Comment> getAllCommentWithArticleForPaging(Integer start,int number) {
		//分页查询
		PageHelper.offsetPage(start,number);
		List<Comment> commentList = commentDao.getAllCommentDesc();
		for(int i = 0;i < commentList.size();i++) {
			//封装文章到每一个评论中
			int articleId = commentList.get(i).getComment_article_id();
			Article article = articleDao.getArticleById(articleId);
			commentList.get(i).setArticle(article);
		}
		return new PageInfo<>(commentList);
	}

	//获取评论总数
	public int getCommentCount() {
		int count = commentDao.getCommentCount();
		return count;
	}

	//根据文章id获取评论集合
	public List<Comment> getCommentByArticleId(int article_id) {
		List<Comment> commentList = commentDao.getCommentByArticleId(article_id);
		return commentList;
	}

	//根据id删除评论
	public void deleteCommentById(int comment_id) {
		commentDao.deleteCommentById(comment_id);
	}

	//添加评论
	public void addComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	//根据id获取评论
	public Comment getCommentById(int comment_id) {
		Comment comment = commentDao.getCommentById(comment_id);
		return comment;
	}

	//更新评论
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

}
