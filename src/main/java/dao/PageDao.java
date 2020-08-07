package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Page;

@Repository
public interface PageDao {
	//获取所有的page
	public List<Page> getAllPage();
	//根据id获取页面
	public Page getPageById(int page_id);
	//更新页面
	public void updatePage(Page page);
	//根据id删除页面
	public void deletePageById(int page_id);
	//增加一个页面
	public void insertPage(Page page);
}
