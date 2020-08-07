package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Article_Category_Ref_Dao;
import entity.Article_Category_Ref;
import service.Article_Category_Ref_Service;

@Service
public class Article_Category_Ref_ServiceImpl implements Article_Category_Ref_Service{

	@Autowired
	Article_Category_Ref_Dao article_Category_Ref_Dao;
	
	//根据article_id获取Article_Category_Ref
	public List<Article_Category_Ref> get_Article_Category_Ref_ByArticleId(int article_id) {
		List<Article_Category_Ref> article_Category_Ref_list = article_Category_Ref_Dao.get_Article_Category_Ref_ByArticleId(article_id);
		return article_Category_Ref_list;
	}

	//根据category_id获取Article-Category_Ref
	public List<Article_Category_Ref> get_Article_Category_Ref_ByCategoryId(int category_id) {
		List<Article_Category_Ref> article_Category_Ref_list = article_Category_Ref_Dao.get_Article_Category_Ref_ByCategoryId(category_id);
		return article_Category_Ref_list;
	}

	//根据article_id删除中间表
	public void delete_Article_Category_RefByArticleId(Integer article_id) {
		article_Category_Ref_Dao.delete_Article_Category_RefByArticleId(article_id);
	}

	//增加一条数据
	public void add_Article_Category_Ref(Integer article_id, Integer category_id) {
		article_Category_Ref_Dao.insert_Article_Category_Ref(article_id,category_id);
	}

}
