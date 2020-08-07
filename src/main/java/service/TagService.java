package service;

import java.util.List;

import entity.Category;
import entity.Tag;

public interface TagService {
	//获取所有的标签
	public List<Tag> getAllTag();
	//根据id获取标签
	public Tag getTagById(int id);
	//获取所有的标签（封装文章）
	public List<Tag> getAllTagWithArticle();
	//获取标签总数
	public int getTagCount();
	//增加一个标签
	public void addTag(Tag tag);
	//根据id删除标签
	public void deleteTagById(int tag_id);
	//更新标签
	public void updateTag(Tag tag);
}
