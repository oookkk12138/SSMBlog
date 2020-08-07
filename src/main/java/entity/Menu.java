package entity;

public class Menu {
	private Integer menu_id;
	private String menu_name;
	private String menu_url;
	private Integer menu_level;
	private String menu_icon;
	private Integer menu_order;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Menu [menu_id=");
		builder.append(menu_id);
		builder.append(", menu_name=");
		builder.append(menu_name);
		builder.append(", menu_url=");
		builder.append(menu_url);
		builder.append(", menu_level=");
		builder.append(menu_level);
		builder.append(", menu_icon=");
		builder.append(menu_icon);
		builder.append(", menu_order=");
		builder.append(menu_order);
		builder.append("]");
		return builder.toString();
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public Integer getMenu_level() {
		return menu_level;
	}
	public void setMenu_level(Integer menu_level) {
		this.menu_level = menu_level;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	public Integer getMenu_order() {
		return menu_order;
	}
	public void setMenu_order(Integer menu_order) {
		this.menu_order = menu_order;
	}
}
