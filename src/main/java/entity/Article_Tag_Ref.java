package entity;

public class Article_Tag_Ref {
	private Integer article_id;
	private Integer tag_id;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article_Tag_Ref [article_id=");
		builder.append(article_id);
		builder.append(", tag_id=");
		builder.append(tag_id);
		builder.append("]");
		return builder.toString();
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
}
