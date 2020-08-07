package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Comment;

@Repository
public interface CommentDao {
	//倒序获取所有的评论
	public List<Comment> getAllCommentDesc();
	//获取评论总数
	public int getCommentCount();
	//根据文章id获取评论集合
	public List<Comment> getCommentByArticleId(int article_id);
	//根据id删除评论
	public void deleteCommentById(int comment_id);
	//增加评论
	public void insertComment(Comment comment);
	//根据id获取评论
	public Comment getCommentById(int comment_id);
	//更新评论
	public void updateComment(Comment comment);
}
