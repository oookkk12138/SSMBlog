package service;

import java.util.List;

import entity.Category;

public interface CategoryService {
	//获取所有的分类
	public List<Category> getAllCategory();
	//根据id获取分类
	public Category getCategoryById(int id);
	//获取所有的分类（封装文章）
	public List<Category> getAllCategoryWithArticle();
	//获取分类总数
	public int getCategoryCount();
	//增加一个分类
	public void addCategory(Category category);
	//根据category_id删除分类
	public void deleteCategoryById(int category_id);
	//更新分类
	public void updateCategory(Category category);
}
