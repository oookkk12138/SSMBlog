package entity;

import java.util.Date;
import java.util.List;

public class Article {
	private Integer article_id;
	private Integer article_userid;
	private String article_title;
	private String article_content;
	private Integer article_view_count;
	private Integer article_comment_count;
	private Integer article_like_count;
	private Integer article_status;
	private Integer article_order;
	private Date article_update_time;
	private Date article_create_time;
	private String article_summary;
	private List<Category> categoryList;
	private List<Tag> tagList;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [article_id=");
		builder.append(article_id);
		builder.append(", article_userid=");
		builder.append(article_userid);
		builder.append(", article_title=");
		builder.append(article_title);
		builder.append(", article_content=");
		builder.append(article_content);
		builder.append(", article_view_count=");
		builder.append(article_view_count);
		builder.append(", article_comment_count=");
		builder.append(article_comment_count);
		builder.append(", article_like_count=");
		builder.append(article_like_count);
		builder.append(", article_status=");
		builder.append(article_status);
		builder.append(", article_order=");
		builder.append(article_order);
		builder.append(", article_update_time=");
		builder.append(article_update_time);
		builder.append(", article_create_time=");
		builder.append(article_create_time);
		builder.append(", article_summary=");
		builder.append(article_summary);
		builder.append(", categoryList=");
		builder.append(categoryList);
		builder.append(", tagList=");
		builder.append(tagList);
		builder.append("]");
		return builder.toString();
	}
	public Integer getArticle_view_count() {
		return article_view_count;
	}
	public void setArticle_view_count(Integer article_view_count) {
		this.article_view_count = article_view_count;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getArticle_userid() {
		return article_userid;
	}
	public void setArticle_userid(Integer article_userid) {
		this.article_userid = article_userid;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public Integer getArticle_comment_count() {
		return article_comment_count;
	}
	public void setArticle_comment_count(Integer article_comment_count) {
		this.article_comment_count = article_comment_count;
	}
	public Integer getArticle_like_count() {
		return article_like_count;
	}
	public void setArticle_like_count(Integer article_like_count) {
		this.article_like_count = article_like_count;
	}
	public Integer getArticle_status() {
		return article_status;
	}
	public void setArticle_status(Integer article_status) {
		this.article_status = article_status;
	}
	public Integer getArticle_order() {
		return article_order;
	}
	public void setArticle_order(Integer article_order) {
		this.article_order = article_order;
	}
	public Date getArticle_update_time() {
		return article_update_time;
	}
	public void setArticle_update_time(Date article_update_time) {
		this.article_update_time = article_update_time;
	}
	public Date getArticle_create_time() {
		return article_create_time;
	}
	public void setArticle_create_time(Date article_create_time) {
		this.article_create_time = article_create_time;
	}
	public String getArticle_summary() {
		return article_summary;
	}
	public void setArticle_summary(String article_summary) {
		this.article_summary = article_summary;
	}
}
