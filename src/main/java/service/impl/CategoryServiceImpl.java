package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ArticleDao;
import dao.Article_Category_Ref_Dao;
import dao.CategoryDao;
import entity.Article;
import entity.Article_Category_Ref;
import entity.Category;
import service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ArticleDao articleDao;
	
	@Autowired
	Article_Category_Ref_Dao article_Category_Ref_Dao;
	
	//获取所有的分类
	public List<Category> getAllCategory() {
		List<Category> categoryList = categoryDao.getAllCategory();
		return categoryList;
	}

	//根据id获取分类
	public Category getCategoryById(int id) {
		Category category = categoryDao.getCategoryById(id);
		return category;
	}
	
	//获取所有的分类（封装文章）
	public List<Category> getAllCategoryWithArticle() {
		//获取所有的分类
		List<Category> categoryList = categoryDao.getAllCategory();
		for(int i = 0;i < categoryList.size();i++) {
			//根据category_id获取所有的文章_分类中间表
			List<Article_Category_Ref> article_Category_Ref_list = article_Category_Ref_Dao.get_Article_Category_Ref_ByCategoryId(categoryList.get(i).getCategory_id());
			//创建文章集合
			List<Article> articleList = new ArrayList<Article>();
			for(int j = 0;j < article_Category_Ref_list.size();j++) {
				int articleId = article_Category_Ref_list.get(j).getArticle_id();
				Article article = articleDao.getArticleById(articleId);
				articleList.add(article);
			}
			categoryList.get(i).setArticleList(articleList);
		}
		return categoryList;
	}

	//获取分类总数
	public int getCategoryCount() {
		int count = categoryDao.getCategoryCount();
		return count;
	}

	//增加一个分类
	public void addCategory(Category category) {
		categoryDao.insertCategory(category);
	}

	//根据category_id删除分类
	public void deleteCategoryById(int category_id) {
		categoryDao.deleteCategoryById(category_id);
	}

	//更新分类
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

}
