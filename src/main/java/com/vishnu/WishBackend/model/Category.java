package com.vishnu.WishBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int catergoryId;
	
	@Column
	private String categoryName;
	public int getCatergoryId() {
		return catergoryId;
	}
	public void setCatergoryId(int catergoryId) {
		this.catergoryId = catergoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	@Column
    private	String categoryDiscription;

}
