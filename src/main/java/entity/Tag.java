package entity;

import java.util.List;

public class Tag {
	private Integer tag_id;
	private String tag_name;
	private String tag_description;
	private List<Article> articleList;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [tag_id=");
		builder.append(tag_id);
		builder.append(", tag_name=");
		builder.append(tag_name);
		builder.append(", tag_description=");
		builder.append(tag_description);
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
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getTag_description() {
		return tag_description;
	}
	public void setTag_description(String tag_description) {
		this.tag_description = tag_description;
	}
}
