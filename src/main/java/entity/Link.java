package entity;

import java.util.Date;

public class Link {
	private Integer link_id;
	private String link_url;
	private String link_name;
	private String link_description;
	private String link_owner_contact;
	private Date link_update_time;
	private Date link_create_time;
	private Integer link_order;
	private Integer link_status;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link [link_id=");
		builder.append(link_id);
		builder.append(", link_url=");
		builder.append(link_url);
		builder.append(", link_name=");
		builder.append(link_name);
		builder.append(", link_description=");
		builder.append(link_description);
		builder.append(", link_owner_contact=");
		builder.append(link_owner_contact);
		builder.append(", link_update_time=");
		builder.append(link_update_time);
		builder.append(", link_create_time=");
		builder.append(link_create_time);
		builder.append(", link_order=");
		builder.append(link_order);
		builder.append(", link_status=");
		builder.append(link_status);
		builder.append("]");
		return builder.toString();
	}
	public String getLink_owner_contact() {
		return link_owner_contact;
	}
	public void setLink_owner_contact(String link_owner_contact) {
		this.link_owner_contact = link_owner_contact;
	}
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_description() {
		return link_description;
	}
	public void setLink_description(String link_description) {
		this.link_description = link_description;
	}
	public Date getLink_update_time() {
		return link_update_time;
	}
	public void setLink_update_time(Date link_update_time) {
		this.link_update_time = link_update_time;
	}
	public Date getLink_create_time() {
		return link_create_time;
	}
	public void setLink_create_time(Date link_create_time) {
		this.link_create_time = link_create_time;
	}
	public Integer getLink_order() {
		return link_order;
	}
	public void setLink_order(Integer link_order) {
		this.link_order = link_order;
	}
	public Integer getLink_status() {
		return link_status;
	}
	public void setLink_status(Integer link_status) {
		this.link_status = link_status;
	}
}
