package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import entity.Comment;

public interface CommentService {
	//倒叙获取5条评论
	public List<Comment> getLastFiveComment();
	//倒序获取所有评论，并且分页（封装文章）
	public PageInfo<Comment> getAllCommentWithArticleForPaging(Integer start,int number);
	//获取评论总数
	public int getCommentCount();
	//根据文章id获取评论集合
	public List<Comment> getCommentByArticleId(int article_id);
	//根据id删除评论
	public void deleteCommentById(int comment_id);
	//添加评论
	public void addComment(Comment comment);
	//根据id获取评论
	public Comment getCommentById(int comment_id);
	//更新评论
	public void updateComment(Comment comment);
}
