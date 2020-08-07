package entity;

public class Article_Category_Ref {
	private Integer article_id;
	private Integer category_id;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article_Category_Ref [article_id=");
		builder.append(article_id);
		builder.append(", category_id=");
		builder.append(category_id);
		builder.append("]");
		return builder.toString();
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
}
