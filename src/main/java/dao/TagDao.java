package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Category;
import entity.Tag;

@Repository
public interface TagDao {
	//获取所有的标签
	public List<Tag> getAllTag();
	//根据id获取标签
	public Tag getTagById(int id);
	//获取标签总数
	public int getTagCount();
	//增加一个标签
	public void insertTag(Tag tag);
	//根据id删除标签
	public void deleteTagById(int tag_id);
	//更新标签
	public void updateTag(Tag tag);
}
