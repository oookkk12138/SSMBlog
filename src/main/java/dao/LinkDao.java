package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Link;

@Repository
public interface LinkDao {
	//查询所有的连接(status升序、order降序、id升序)
	public List<Link> getAllLink();
	//获取链接总数
	public int getLinkCount();
	//增加一个连接
	public void insertLink(Link link);
	//根据状态获取链接
	public List<Link> getAllLinkByStatus(int link_status);
	//根据id获取链接
	public Link getLinkById(int link_id);
	//更新链接
	public void updateLink(Link link);
	//根据id删除链接
	public void deleteLinkById(int link_id);
}
