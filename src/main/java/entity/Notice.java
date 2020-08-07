package entity;

import java.util.Date;

public class Notice {
	private Integer notice_id;
	private String notice_title;
	private String notice_content;
	private Date notice_create_time;
	private Date notice_update_time;
	private Integer notice_status;
	private Integer notice_order;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [notice_id=");
		builder.append(notice_id);
		builder.append(", notice_title=");
		builder.append(notice_title);
		builder.append(", notice_content=");
		builder.append(notice_content);
		builder.append(", notice_create_time=");
		builder.append(notice_create_time);
		builder.append(", notice_update_time=");
		builder.append(notice_update_time);
		builder.append(", notice_status=");
		builder.append(notice_status);
		builder.append(", notice_order=");
		builder.append(notice_order);
		builder.append("]");
		return builder.toString();
	}
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getNotice_create_time() {
		return notice_create_time;
	}
	public void setNotice_create_time(Date notice_create_time) {
		this.notice_create_time = notice_create_time;
	}
	public Date getNotice_update_time() {
		return notice_update_time;
	}
	public void setNotice_update_time(Date notice_update_time) {
		this.notice_update_time = notice_update_time;
	}
	public Integer getNotice_status() {
		return notice_status;
	}
	public void setNotice_status(Integer notice_status) {
		this.notice_status = notice_status;
	}
	public Integer getNotice_order() {
		return notice_order;
	}
	public void setNotice_order(Integer notice_order) {
		this.notice_order = notice_order;
	}
}
