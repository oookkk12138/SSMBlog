package entity;

import java.util.Date;
import java.util.List;

public class User{
	private Integer user_id;
	private String user_name;
	private String user_password;
	private String user_nickname;
	private String user_email;
	private String user_url;
	private String user_avator;
	private String user_last_login_ip;
	private Date user_register_time;
	private Date user_last_login_time;
	private Integer user_status;
	private List<Article> articleList;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [user_id=");
		builder.append(user_id);
		builder.append(", user_name=");
		builder.append(user_name);
		builder.append(", user_password=");
		builder.append(user_password);
		builder.append(", user_nickname=");
		builder.append(user_nickname);
		builder.append(", user_email=");
		builder.append(user_email);
		builder.append(", user_url=");
		builder.append(user_url);
		builder.append(", user_avator=");
		builder.append(user_avator);
		builder.append(", user_last_login_ip=");
		builder.append(user_last_login_ip);
		builder.append(", user_register_time=");
		builder.append(user_register_time);
		builder.append(", user_last_login_time=");
		builder.append(user_last_login_time);
		builder.append(", user_status=");
		builder.append(user_status);
		builder.append(", articleList=");
		builder.append(articleList);
		builder.append("]");
		return builder.toString();
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_url() {
		return user_url;
	}
	public void setUser_url(String user_url) {
		this.user_url = user_url;
	}
	public String getUser_avator() {
		return user_avator;
	}
	public void setUser_avator(String user_avator) {
		this.user_avator = user_avator;
	}
	public String getUser_last_login_ip() {
		return user_last_login_ip;
	}
	public void setUser_last_login_ip(String user_last_login_ip) {
		this.user_last_login_ip = user_last_login_ip;
	}
	public Date getUser_register_time() {
		return user_register_time;
	}
	public void setUser_register_time(Date user_register_time) {
		this.user_register_time = user_register_time;
	}
	public Date getUser_last_login_time() {
		return user_last_login_time;
	}
	public void setUser_last_login_time(Date user_last_login_time) {
		this.user_last_login_time = user_last_login_time;
	}
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
}