package service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import entity.Article;
import entity.Category;
import entity.Comment;

public interface ArticleService {
	//倒叙获取所有文章
	public List<Article> getAllArticleDesc();
	//根据id获取对应的文章
	public Article getArticleById(Integer id);
	//根据5个评论获取对应的5个文章（index页面用到）
	public List<Article> getFiveArticleByFiveComment(List<Comment> commentList);
	//获取文章的分类（10个）并且封装CategoryList(start:开始页数 number：分页数量)
	public PageInfo<Article> getArticleForPaging(int start,int number);
	//根据id获取文章并且封装CategoryList和TagList
	public Article getArticleByIdWithCategoryListAndTagList(int article_id);
	//获取文章总数
	public int getArticleCount();
	//获取文章总浏览量
	public int getTotalViewCount();
	//获取观看数最多的5条文章（热评文章）
	public List<Article> getFiveHotViewArticle();
	//根据状态获取所有的文章
	public List<Article> getAllArticleByStatus(int article_status);
	//根据分类id获取文章的分页
	public Map<String,Object> getArticleByCategoryForPaging(int start,int number,int category_id);
	//根据标签id获取文章的分页
	public Map<String,Object> getArticleByTagForPaging(int start,int number,int tag_id);
	//根据artitle_title模糊查询文章,并关联category，并进行分页
	public PageInfo<Article> getArticleWithVagueTitleForPaging(String article_title,int start,int number);
	//修改文章
	public void updateArticle(Article article);
	//根据id删除文章
	public void deleteArticleById(int article_id);
	//增加一个文章
	public void addArticle(Article article);
}
