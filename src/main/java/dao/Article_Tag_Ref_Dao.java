package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import entity.Article_Tag_Ref;

@Repository
public interface Article_Tag_Ref_Dao {
	//根据article_id获取Article_Tag_Ref
	public List<Article_Tag_Ref> get_Article_Tag_Ref_ByArticleId(int article_id);
	//根据tag_id获取Article_Tag_Ref
	public List<Article_Tag_Ref> get_Article_Tag_Ref_ByTagId(int tag_id);
	//根据article_id删除数据
	public void delete_Article_Tag_RefByArticleId(Integer article_id);
	//增加一条中间表
	public void insert_Article_Tag_Ref(@Param("article_id") Integer article_id,@Param("tag_id") Integer tag_id);
}
