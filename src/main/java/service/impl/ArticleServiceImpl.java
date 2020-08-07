package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.ArticleDao;
import dao.Article_Category_Ref_Dao;
import dao.Article_Tag_Ref_Dao;
import dao.CategoryDao;
import dao.TagDao;
import entity.Article;
import entity.Article_Category_Ref;
import entity.Article_Tag_Ref;
import entity.Category;
import entity.Comment;
import entity.Tag;
import service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao articleDao;
	
	@Autowired
	Article_Category_Ref_Dao article_Category_Ref_Dao;
	
	@Autowired
	Article_Tag_Ref_Dao article_Tag_Ref_Dao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	TagDao tagDao;
	
	//倒序获取所有文章
	public List<Article> getAllArticleDesc() {
		List<Article> articleList = articleDao.getAllArticleDesc();
		return articleList;
	}

	//根据id获取对应的文章
	public Article getArticleById(Integer id) {
		Article article = articleDao.getArticleById(id);
		return article;
	}

	//根据5个评论获取对应的5个文章（index页面用到）
	public List<Article> getFiveArticleByFiveComment(List<Comment> commentList) {
		List<Article> fiveArticle = new ArrayList<Article>();
		for(int i = 0;i < commentList.size();i++) {
			Article article = articleDao.getArticleById(commentList.get(i).getComment_article_id());
			fiveArticle.add(article);
		}
		return fiveArticle;
	}

	//获取文章的分类（10个）并且封装CategoryList
	public PageInfo<Article> getArticleForPaging(int start,int number) {
		PageHelper.startPage(start,number);
		//分页查询10个文章
		PageHelper.offsetPage(start,number);
		List<Article> articleList = articleDao.getAllArticleDesc();
		//循环
		for(int i = 0;i < articleList.size();i++) {
			//根据article_id获取所有的文章_分类中间表
			List<Article_Category_Ref> article_Category_Ref_list = article_Category_Ref_Dao.get_Article_Category_Ref_ByArticleId(articleList.get(i).getArticle_id());
			//创建分类集合
			List<Category> categoryList = new ArrayList<Category>();
			//根据中间表获取所有对应的分类
			for(int j = 0;j < article_Category_Ref_list.size();j++) {
				int categoryId = article_Category_Ref_list.get(j).getCategory_id();
				Category category = categoryDao.getCategoryById(categoryId);
				categoryList.add(category);
			}
			//封装分类集合到文章中
			articleList.get(i).setCategoryList(categoryList);
		}
		return new PageInfo<>(articleList);
	}

	//根据id获取文章并且封装CategoryList和TagList
	public Article getArticleByIdWithCategoryListAndTagList(int article_id) {
		Article article = articleDao.getArticleById(article_id);
		//创建categoryList和tagList集合
		List<Category> categoryList = new ArrayList<Category>();
		List<Tag> tagList = new ArrayList<Tag>();
		//根据article_id获取所有的文章_分类中间表
		List<Article_Category_Ref> article_Category_Ref_list = article_Category_Ref_Dao.get_Article_Category_Ref_ByArticleId(article_id);
		//根据article_id获取所有的文章_标签中间表
		List<Article_Tag_Ref> article_Tag_Ref_list = article_Tag_Ref_Dao.get_Article_Tag_Ref_ByArticleId(article_id);
		//根据中间表获取所有对应的分类
		for(int j = 0;j < article_Category_Ref_list.size();j++) {
			//获取category并添加到categoryList中
			int categoryId = article_Category_Ref_list.get(j).getCategory_id();
			Category category = categoryDao.getCategoryById(categoryId);
			categoryList.add(category);
		}
		//获取tag并添加到tag中
		for(int k = 0;k < article_Tag_Ref_list.size();k++) {
			int tagId = article_Tag_Ref_list.get(k).getTag_id();
			Tag tag = tagDao.getTagById(tagId);
			tagList.add(tag);
		}
		//封装分类集合到文章中
		article.setCategoryList(categoryList);
		//封装标签集合到文章中
		article.setTagList(tagList);
		return article;
	}

	//获取文章总数
	public int getArticleCount() {
		int count = articleDao.getArticleCount();
		return count;
	}

	//获取文章总浏览量
	public int getTotalViewCount() {
		int count = articleDao.getTotalViewCount();
		return count;
	}

	//获取观看数最多的5条文章（热评文章）
	public List<Article> getFiveHotViewArticle() {
		List<Article> articleList = articleDao.getFiveHotViewArticle();
		return articleList;
	}

	//根据状态获取所有的文章
	public List<Article> getAllArticleByStatus(int article_status) {
		List<Article> articleList = articleDao.getAllArticleByStatus(article_status);
		return articleList;
	}

	//根据分类id获取文章的分页(使用map作为返回值解决分页的缺点)
	public Map<String,Object> getArticleByCategoryForPaging(int start, int number, int category_id) {
		//根据categoryId获取artciel-category中间表
		PageHelper.offsetPage(start,number);
		List<Article_Category_Ref> article_Category_Ref_list = article_Category_Ref_Dao.get_Article_Category_Ref_ByCategoryId(category_id);
		//根据此中间表获取文章
		List<Article> articleList = new ArrayList<Article>();
		for(int i = 0;i < article_Category_Ref_list.size();i++) {
			int articleId = article_Category_Ref_list.get(i).getArticle_id();
			Article article = articleDao.getArticleById(articleId);
			articleList.add(article);
		}
		//保存数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageInfo",new PageInfo<>(article_Category_Ref_list));
		map.put("articleList",articleList);
		return map;
	}

	//根据标签id获取文章的分页
	public Map<String, Object> getArticleByTagForPaging(int start, int number, int tag_id) {
		//根据tag_id获取article-tag中间表
		PageHelper.offsetPage(start,number);
		List<Article_Tag_Ref> article_Tag_Ref_list = article_Tag_Ref_Dao.get_Article_Tag_Ref_ByTagId(tag_id);
		//根据此中间表获取文章
		List<Article> articleList = new ArrayList<Article>();
		for(int i = 0;i < article_Tag_Ref_list.size();i++) {
			int articleId = article_Tag_Ref_list.get(i).getArticle_id();
			Article article = articleDao.getArticleById(articleId);
			articleList.add(article);
			//根据articleId获取article-category中间表
			List<Article_Category_Ref> article_Category_Ref_List = article_Category_Ref_Dao.get_Article_Category_Ref_ByArticleId(articleId);
			//根据中间表获取分类，并封装到文章中
			List<Category> categoryList = new ArrayList<Category>();
			for(int k = 0;k < article_Category_Ref_List.size();k++) {
				int categoryId = article_Category_Ref_List.get(k).getCategory_id();
				Category category = categoryDao.getCategoryById(categoryId);
				categoryList.add(category);
			}
			article.setCategoryList(categoryList);
		}
		//保存数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageInfo",new PageInfo<>(article_Tag_Ref_list));
		map.put("articleList",articleList);
		return map;
	}

	//根据artitle_title模糊查询文章,并关联category，并进行分页
	public PageInfo<Article> getArticleWithVagueTitleForPaging(String article_title,int start,int number) {
		//查询出相关的文章
		PageHelper.offsetPage(start,number);
		List<Article> articleList = articleDao.getArticleWithVagueTitle(article_title);
		for(int i = 0;i < articleList.size();i++) {
			int articleId = articleList.get(i).getArticle_id();
			//根据文章id获取article_category中间表
			List<Article_Category_Ref> article_Category_Ref_List = article_Category_Ref_Dao.get_Article_Category_Ref_ByArticleId(articleId);
			//根据article_Categort中间表获取分类
			List<Category> categoryList = new ArrayList<Category>();
			for(int j = 0;j < article_Category_Ref_List.size();j++) {
				//根据中间表获取分类
				int categoryId = article_Category_Ref_List.get(j).getCategory_id();
				Category category = categoryDao.getCategoryById(categoryId);
				categoryList.add(category);
			}
			articleList.get(i).setCategoryList(categoryList);
		}
		return new PageInfo<>(articleList);
	}

	//修改文章
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

	//根据id删除文章
	public void deleteArticleById(int article_id) {
		articleDao.deleteArticleById(article_id);
	}

	//增加一个文章
	public void addArticle(Article article) {
		articleDao.insertArticle(article);
	}

}
