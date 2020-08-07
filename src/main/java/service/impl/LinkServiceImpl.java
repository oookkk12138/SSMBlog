package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LinkDao;
import entity.Link;
import service.LinkService;

@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	LinkDao linkDao;
	
	//获取所有的连接
	public List<Link> getAllLink() {
		List<Link> linkList = linkDao.getAllLink();
		return linkList;
	}

	//获取链接总数
	public int getLinkCount() {
		int count = linkDao.getLinkCount();
		return count;
	}

	//增加一个连接
	public void insertLink(Link link) {
		linkDao.insertLink(link);
	}

	//根据状态获取链接
	public List<Link> getAllLinkByStatus(int link_status) {
		List<Link> linkList = linkDao.getAllLinkByStatus(link_status);
		return linkList;
	}

	//根据id获取链接
	public Link getLinkById(int link_id) {
		Link link = linkDao.getLinkById(link_id);
		return link;
	}

	//更新链接
	public void updateLink(Link link) {
		linkDao.updateLink(link);
	}

	//根据id删除链接
	public void deleteLinkById(int link_id) {
		linkDao.deleteLinkById(link_id);
	}

}
