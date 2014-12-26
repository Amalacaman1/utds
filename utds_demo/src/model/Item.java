package model;

import java.io.Serializable;

public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2723122543600230321L;
	private int id;
	private String name;
	private String category;
	private String dateModified;
	private String objectVersion;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public String getObjectVersion() {
		return objectVersion;
	}
	public void setObjectVersion(String objectVersion) {
		this.objectVersion = objectVersion;
	}
}
