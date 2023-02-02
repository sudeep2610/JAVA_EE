package org.fi.allcompleterestboot.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products_0049")
public class Product {

	@EmbeddedId
	ProductId id;

	@Column(name="productname")
	String productName;
	
	@Column(name="productdescription")
	String productDescription;
	
	@Column(name="productprice")
	float productPrice;

	@Column(name="productimageurl")
	String productImageUrl;

	

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

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public ProductId getId() {
		return id;
	}

	public void setId(ProductId id) {
		this.id = id;
	}
	
	
}
