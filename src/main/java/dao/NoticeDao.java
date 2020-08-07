package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Notice;

@Repository
public interface NoticeDao {
	//获取所有的公告
	public List<Notice> getAllNotice();
	//根据id获取公告
	public Notice getNoticeById(int id);
	//增加一个公告
	public void insertNotice(Notice notice);
	//更新公告
	public void updateNotice(Notice notice);
	//根据id删除公告
	public void deleteNoticeById(int notice_id);
}
