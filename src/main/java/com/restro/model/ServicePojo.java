package com.restro.model;

public class ServicePojo {
    private int sno;
	private String iconName;
	private String title;
	private String description;
	private String dateTime;
	public ServicePojo(int sno,String iconName, String title, String description, String dateTime) {
		super();
		this.sno=sno;
		this.iconName = iconName;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
	}
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "ServicePojo [iconName=" + iconName + ", title=" + title + ", description=" + description + ", dateTime="
				+ dateTime + "]";
	}
	
	
}
