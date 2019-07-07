package com.vishnu.WishBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class Product {

	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}



	@Id
	private int productId;
	@Column
	private String productName;
	
	@Column
	private String productDescription;
	@Column
	private int productPrice;
	
	@Column
	private String productCategory;
	@Column
	private String productSupplier;
	@Column
	private int stock;
	
	@Transient
	private MultipartFile productImage;

}
