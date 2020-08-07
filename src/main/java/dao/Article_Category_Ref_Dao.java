package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import entity.Article_Category_Ref;

@Repository
public interface Article_Category_Ref_Dao {
	//根据article_id获取Article_Category_Ref
	public List<Article_Category_Ref> get_Article_Category_Ref_ByArticleId(int article_id);
	//根据category_id获取Article_Category_Ref
	public List<Article_Category_Ref> get_Article_Category_Ref_ByCategoryId(int category_id);
	//根据article_id删除数据
	public void delete_Article_Category_RefByArticleId(Integer article_id);
	//增加一条数据
	public void insert_Article_Category_Ref(@Param("article_id") Integer article_id,@Param("category_id") Integer category_id);
}
