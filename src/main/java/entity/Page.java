package entity;

import java.util.Date;

public class Page {
	private Integer page_id;
	private String page_key;
	private String page_title;
	private String page_content;
	private Date page_create_time;
	private Date page_update_time;
	private Integer page_view_count;
	private Integer page_comment_count;
	private Integer page_status;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [page_id=");
		builder.append(page_id);
		builder.append(", page_key=");
		builder.append(page_key);
		builder.append(", page_title=");
		builder.append(page_title);
		builder.append(", page_content=");
		builder.append(page_content);
		builder.append(", page_create_time=");
		builder.append(page_create_time);
		builder.append(", page_update_time=");
		builder.append(page_update_time);
		builder.append(", page_view_count=");
		builder.append(page_view_count);
		builder.append(", page_comment_count=");
		builder.append(page_comment_count);
		builder.append(", page_status=");
		builder.append(page_status);
		builder.append("]");
		return builder.toString();
	}
	public Integer getPage_id() {
		return page_id;
	}
	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}
	public String getPage_key() {
		return page_key;
	}
	public void setPage_key(String page_key) {
		this.page_key = page_key;
	}
	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
	public String getPage_content() {
		return page_content;
	}
	public void setPage_content(String page_content) {
		this.page_content = page_content;
	}
	public Date getPage_create_time() {
		return page_create_time;
	}
	public void setPage_create_time(Date page_create_time) {
		this.page_create_time = page_create_time;
	}
	public Date getPage_update_time() {
		return page_update_time;
	}
	public void setPage_update_time(Date page_update_time) {
		this.page_update_time = page_update_time;
	}
	public Integer getPage_view_count() {
		return page_view_count;
	}
	public void setPage_view_count(Integer page_view_count) {
		this.page_view_count = page_view_count;
	}
	public Integer getPage_comment_count() {
		return page_comment_count;
	}
	public void setPage_comment_count(Integer page_comment_count) {
		this.page_comment_count = page_comment_count;
	}
	public Integer getPage_status() {
		return page_status;
	}
	public void setPage_status(Integer page_status) {
		this.page_status = page_status;
	}
}
