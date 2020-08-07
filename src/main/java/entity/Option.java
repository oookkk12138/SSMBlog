package entity;

public class Option {
	private Integer option_id;
	private String option_site_url;
	private String option_site_title;
	private String option_site_description;
	private String option_meta_description;
	private String option_meta_keyword;
	private String option_aboutsite_avator;
	private String option_aboutsite_title;
	private String option_aboutsite_content;
	private String option_aboutsite_wechat;
	private String option_aboutsite_qq;
	private String option_aboutsite_github;
	private String option_aboutsite_weibo;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Option [option_id=");
		builder.append(option_id);
		builder.append(", option_site_url=");
		builder.append(option_site_url);
		builder.append(", option_site_title=");
		builder.append(option_site_title);
		builder.append(", option_site_description=");
		builder.append(option_site_description);
		builder.append(", option_meta_description=");
		builder.append(option_meta_description);
		builder.append(", option_meta_keyword=");
		builder.append(option_meta_keyword);
		builder.append(", option_aboutsite_avator=");
		builder.append(option_aboutsite_avator);
		builder.append(", option_aboutsite_title=");
		builder.append(option_aboutsite_title);
		builder.append(", option_aboutsite_content=");
		builder.append(option_aboutsite_content);
		builder.append(", option_aboutsite_wechat=");
		builder.append(option_aboutsite_wechat);
		builder.append(", option_aboutsite_qq=");
		builder.append(option_aboutsite_qq);
		builder.append(", option_aboutsite_github=");
		builder.append(option_aboutsite_github);
		builder.append(", option_aboutsite_weibo=");
		builder.append(option_aboutsite_weibo);
		builder.append("]");
		return builder.toString();
	}
	public String getOption_site_url() {
		return option_site_url;
	}
	public void setOption_site_url(String option_site_url) {
		this.option_site_url = option_site_url;
	}
	public String getOption_aboutsite_title() {
		return option_aboutsite_title;
	}
	public void setOption_aboutsite_title(String option_aboutsite_title) {
		this.option_aboutsite_title = option_aboutsite_title;
	}
	public String getOption_aboutsite_avator() {
		return option_aboutsite_avator;
	}
	public void setOption_aboutsite_avator(String option_aboutsite_avator) {
		this.option_aboutsite_avator = option_aboutsite_avator;
	}
	public String getOption_meta_keyword() {
		return option_meta_keyword;
	}
	public void setOption_meta_keyword(String option_meta_keyword) {
		this.option_meta_keyword = option_meta_keyword;
	}
	public Integer getOption_id() {
		return option_id;
	}
	public void setOption_id(Integer option_id) {
		this.option_id = option_id;
	}
	public String getOption_site_title() {
		return option_site_title;
	}
	public void setOption_site_title(String option_site_title) {
		this.option_site_title = option_site_title;
	}
	public String getOption_site_description() {
		return option_site_description;
	}
	public void setOption_site_description(String option_site_description) {
		this.option_site_description = option_site_description;
	}
	public String getOption_meta_description() {
		return option_meta_description;
	}
	public void setOption_meta_description(String option_meta_description) {
		this.option_meta_description = option_meta_description;
	}
	public String getOption_aboutsite_content() {
		return option_aboutsite_content;
	}
	public void setOption_aboutsite_content(String option_aboutsite_content) {
		this.option_aboutsite_content = option_aboutsite_content;
	}
	public String getOption_aboutsite_wechat() {
		return option_aboutsite_wechat;
	}
	public void setOption_aboutsite_wechat(String option_aboutsite_wechat) {
		this.option_aboutsite_wechat = option_aboutsite_wechat;
	}
	public String getOption_aboutsite_qq() {
		return option_aboutsite_qq;
	}
	public void setOption_aboutsite_qq(String option_aboutsite_qq) {
		this.option_aboutsite_qq = option_aboutsite_qq;
	}
	public String getOption_aboutsite_github() {
		return option_aboutsite_github;
	}
	public void setOption_aboutsite_github(String option_aboutsite_github) {
		this.option_aboutsite_github = option_aboutsite_github;
	}
	public String getOption_aboutsite_weibo() {
		return option_aboutsite_weibo;
	}
	public void setOption_aboutsite_weibo(String option_aboutsite_weibo) {
		this.option_aboutsite_weibo = option_aboutsite_weibo;
	}
}
