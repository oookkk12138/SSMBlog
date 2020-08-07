package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Article_Tag_Ref_Dao;
import entity.Article_Tag_Ref;
import service.Article_Tag_Ref_Service;

@Service
public class Article_Tag_Ref_ServiceImpl implements Article_Tag_Ref_Service{
	@Autowired
	Article_Tag_Ref_Dao article_Tag_Ref_Dao;
	
	//根据article_id获取Article_Tag_Ref
	public List<Article_Tag_Ref> get_Article_Tag_Ref_ByArticleId(int article_id) {
		List<Article_Tag_Ref> article_Tag_Ref_list = article_Tag_Ref_Dao.get_Article_Tag_Ref_ByArticleId(article_id);
		return article_Tag_Ref_list;
	}

	//根据tag_id获取Article_Tag_Ref
	public List<Article_Tag_Ref> get_Article_Tag_Ref_ByTagId(int tag_id) {
		List<Article_Tag_Ref> article_Tag_ref_list = article_Tag_Ref_Dao.get_Article_Tag_Ref_ByTagId(tag_id);
		return article_Tag_ref_list;
	}

	//根据article_id删除数据
	public void delete_Article_Tag_RefByArticleId(Integer article_id) {
		article_Tag_Ref_Dao.delete_Article_Tag_RefByArticleId(article_id);
	}

	//增加一个中间表
	public void add_Article_Tag_Ref(Integer article_id, Integer tag_id) {
		article_Tag_Ref_Dao.insert_Article_Tag_Ref(article_id,tag_id);
	}
}
