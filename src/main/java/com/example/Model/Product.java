package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.payload.CategoryDto;

@Entity
@Table(name="product")
public class Product {

	 
	@Id
	@GeneratedValue(strategy  =GenerationType.AUTO)
	private int product_id;
	private String product_name;
	private double product_prize;
	private boolean stock;
	private int product_quantity;
	private boolean live;
	private String product_imageName;
	private String product_desc;

	@ManyToOne()
	//@JoinColumn(name = "category_id")
	private Category category;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_prize() {
		return product_prize;
	}

	public void setProduct_prize(double product_prize) {
		this.product_prize = product_prize;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public String getProduct_imageName() {
		return product_imageName;
	}

	public void setProduct_imageName(String product_imageName) {
		this.product_imageName = product_imageName;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_id, String product_name, double product_prize, boolean stock, int product_quantity,
			boolean live, String product_imageName, String product_desc, Category category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.stock = stock;
		this.product_quantity = product_quantity;
		this.live = live;
		this.product_imageName = product_imageName;
		this.product_desc = product_desc;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_prize="
				+ product_prize + ", stock=" + stock + ", product_quantity=" + product_quantity + ", live=" + live
				+ ", product_imageName=" + product_imageName + ", product_desc=" + product_desc + ", category="
				+ category + "]";
	}
	
	
	
}
