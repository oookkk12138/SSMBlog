package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PageDao;
import entity.Page;
import service.PageService;

@Service
public class PageServiceImpl implements PageService{
	
	@Autowired
	PageDao pageDao;
	
	//获取所有的page
	public List<Page> getAllPage(){
		List<Page> pageList = pageDao.getAllPage();
		return pageList;
	}

	//根据id获取page
	public Page getPageById(int page_id) {
		Page page = pageDao.getPageById(page_id);
		return page;
	}

	//更新页面
	public void updatePage(Page page) {
		pageDao.updatePage(page);
	}

	//根据id删除页面
	public void deletePageById(int page_id) {
		pageDao.deletePageById(page_id);
	}

	//增加一个页面
	public void addPage(Page page) {
		pageDao.insertPage(page);
	}
}
