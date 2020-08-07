package service;

import java.util.List;

import entity.Article_Category_Ref;

public interface Article_Category_Ref_Service {
	//根据article_id获取Article_Category_Ref
	public List<Article_Category_Ref> get_Article_Category_Ref_ByArticleId(int article_id);
	//根据category_id获取Article-Category_Ref
	public List<Article_Category_Ref> get_Article_Category_Ref_ByCategoryId(int category_id);
	//根据article_id删除中间表
	public void delete_Article_Category_RefByArticleId(Integer article_id);
	//增加一条数据
	public void add_Article_Category_Ref(Integer article_id,Integer category_id);
}
