package entity;

import java.util.Date;

public class Comment {
	private Integer comment_id;
	private Integer comment_article_id;
	private String comment_author_name;
	private String comment_author_email;
	private String comment_author_url;
	private String comment_author_avator;
	private String comment_content;
	private String comment_ip;
	private Date comment_create_time;
	private Integer comment_role;
	private Article article;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [comment_id=");
		builder.append(comment_id);
		builder.append(", comment_article_id=");
		builder.append(comment_article_id);
		builder.append(", comment_author_name=");
		builder.append(comment_author_name);
		builder.append(", comment_author_email=");
		builder.append(comment_author_email);
		builder.append(", comment_author_url=");
		builder.append(comment_author_url);
		builder.append(", comment_author_avator=");
		builder.append(comment_author_avator);
		builder.append(", comment_content=");
		builder.append(comment_content);
		builder.append(", comment_ip=");
		builder.append(comment_ip);
		builder.append(", comment_create_time=");
		builder.append(comment_create_time);
		builder.append(", comment_role=");
		builder.append(comment_role);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public Integer getComment_article_id() {
		return comment_article_id;
	}
	public void setComment_article_id(Integer comment_article_id) {
		this.comment_article_id = comment_article_id;
	}
	public String getComment_author_name() {
		return comment_author_name;
	}
	public void setComment_author_name(String comment_author_name) {
		this.comment_author_name = comment_author_name;
	}
	public String getComment_author_email() {
		return comment_author_email;
	}
	public void setComment_author_email(String comment_author_email) {
		this.comment_author_email = comment_author_email;
	}
	public String getComment_author_url() {
		return comment_author_url;
	}
	public void setComment_author_url(String comment_author_url) {
		this.comment_author_url = comment_author_url;
	}
	public String getComment_author_avator() {
		return comment_author_avator;
	}
	public void setComment_author_avator(String comment_author_avator) {
		this.comment_author_avator = comment_author_avator;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_ip() {
		return comment_ip;
	}
	public void setComment_ip(String comment_ip) {
		this.comment_ip = comment_ip;
	}
	public Date getComment_create_time() {
		return comment_create_time;
	}
	public void setComment_create_time(Date comment_create_time) {
		this.comment_create_time = comment_create_time;
	}
	public Integer getComment_role() {
		return comment_role;
	}
	public void setComment_role(Integer comment_role) {
		this.comment_role = comment_role;
	}
}
