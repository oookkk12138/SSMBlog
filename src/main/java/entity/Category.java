package entity;

import java.util.List;

public class Category {
	private Integer category_id;
	private Integer category_pid;
	private String category_name;
	private String category_description;
	private String category_icon;
	private List<Article> articleList;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [category_id=");
		builder.append(category_id);
		builder.append(", category_pid=");
		builder.append(category_pid);
		builder.append(", category_name=");
		builder.append(category_name);
		builder.append(", category_description=");
		builder.append(category_description);
		builder.append(", category_icon=");
		builder.append(category_icon);
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
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getCategory_pid() {
		return category_pid;
	}
	public void setCategory_pid(Integer category_pid) {
		this.category_pid = category_pid;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	public String getCategory_icon() {
		return category_icon;
	}
	public void setCategory_icon(String category_icon) {
		this.category_icon = category_icon;
	}
}
