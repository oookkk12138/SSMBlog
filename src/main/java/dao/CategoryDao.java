package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Category;

@Repository
public interface CategoryDao {
	//查询所有的分类
	public List<Category> getAllCategory();
	//根据id获取分类
	public Category getCategoryById(int id);
	//获取分类总数
	public int getCategoryCount();
	//增加一个分类
	public void insertCategory(Category category);
	//根据category_id删除分类
	public void deleteCategoryById(int category_id);
	//更新分类
	public void updateCategory(Category category);
}
