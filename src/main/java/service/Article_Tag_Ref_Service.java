package service;

import java.util.List;

import entity.Article_Tag_Ref;

public interface Article_Tag_Ref_Service {
	//根据article_id获取Article_Tag_Ref
	public List<Article_Tag_Ref> get_Article_Tag_Ref_ByArticleId(int article_id);
	//根据tag_id获取Article_Tag_Ref
	public List<Article_Tag_Ref> get_Article_Tag_Ref_ByTagId(int tag_id);
	//根据article_id删除数据
	public void delete_Article_Tag_RefByArticleId(Integer article_id);
	//增加一个中间表
	public void add_Article_Tag_Ref(Integer article_id,Integer tag_id);
}
