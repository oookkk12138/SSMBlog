package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Article_Tag_Ref_Dao;
import dao.TagDao;
import entity.Article;
import entity.Article_Tag_Ref;
import entity.Tag;
import service.ArticleService;
import service.TagService;

@Service
public class TagServiceImpl implements TagService{

	@Autowired
	TagDao tagDao;
	
	@Autowired
	ArticleService articleDao;
	
	@Autowired
	Article_Tag_Ref_Dao article_Tag_Ref_Dao;
	
	//获取所有的标签
	public List<Tag> getAllTag() {
		List<Tag> tagList = tagDao.getAllTag();
		return tagList;
	}

	//根据id获取标签
	public Tag getTagById(int id) {
		Tag tag = tagDao.getTagById(id);
		return tag;
	}

	//获取所有的标签（封装文章）
	public List<Tag> getAllTagWithArticle() {
		//获取所有的标签
		List<Tag> tagList = tagDao.getAllTag();
		for(int i = 0;i < tagList.size();i++) {
			//获取所有的文章_标签中间表
			List<Article_Tag_Ref> article_Tag_Ref_list = article_Tag_Ref_Dao.get_Article_Tag_Ref_ByTagId(tagList.get(i).getTag_id());
			//创建文章集合
			List<Article> articleList = new ArrayList<Article>();
			//循环把中间表种的文章数据加到文章集合中
			for(int j = 0;j < article_Tag_Ref_list.size();j++) {
				int articleId = article_Tag_Ref_list.get(j).getArticle_id();
				Article article = articleDao.getArticleById(articleId);
				articleList.add(article);
			}
			//封装文章到标签上
			tagList.get(i).setArticleList(articleList);
		}
		return tagList;
	}

	//获取标签总数
	public int getTagCount() {
		int count = tagDao.getTagCount();
		return count;
	}

	//增加一个标签
	public void addTag(Tag tag) {
		tagDao.insertTag(tag);
	}

	//根据id删除标签
	public void deleteTagById(int tag_id) {
		tagDao.deleteTagById(tag_id);
	}

	//更新标签
	public void updateTag(Tag tag) {
		tagDao.updateTag(tag);
	}
	
}
