package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Article;

@Repository
public interface ArticleDao {
	//倒序获取全部文章
	public List<Article> getAllArticleDesc();
	//根据id获取对应的文章
	public Article getArticleById(Integer id);
	//根据用户id获取对应的文章集合
	public List<Article> getArticleByUserId(int user_id);
	//获取文章的总数
	public int getArticleCount();
	//获取文章的总浏览量
	public int getTotalViewCount();
	//获取观看数最多的5条文章（热评文章）
	public List<Article> getFiveHotViewArticle();
	//根据状态获取所有文章
	public List<Article> getAllArticleByStatus(int article_status);
	//根据artitle_title模糊查询文章
	public List<Article> getArticleWithVagueTitle(String article_title);
	//修改文章
	public void updateArticle(Article article);
	//根据id删除文章
	public void deleteArticleById(int article_id);
	//增加一个文章
	public void insertArticle(Article article);
}
