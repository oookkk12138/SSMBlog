package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NoticeDao;
import entity.Notice;
import service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeDao noticeDao;
	
	//获取所有的公告
	public List<Notice> getAllNotice() {
		List<Notice> noticeList = noticeDao.getAllNotice();
		return noticeList;
	}

	//根据id获取公告
	public Notice getNoticeById(int id) {
		Notice notice = noticeDao.getNoticeById(id);
		return notice;
	}

	//增加一个公告
	public void addNotice(Notice notice) {
		noticeDao.insertNotice(notice);
	}

	//更新公告
	public void updateNotice(Notice notice) {
		noticeDao.updateNotice(notice);
	}

	//根据id删除公告
	public void deleteNoticeById(int notice_id) {
		noticeDao.deleteNoticeById(notice_id);
	}
	
	
}
