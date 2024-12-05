package com.Nimap.app.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cid")  

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private String categorytype;

	@OneToMany(mappedBy = "category")
	private List<Product> products;

	public Category() {
		super();
	}

	public Category(int cid, String cname, String categorytype, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.categorytype = categorytype;
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", categorytype=" + categorytype + ", products=" + products
				+ "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(String cname, String categorytype, List<Product> products) {
		super();
		this.cname = cname;
		this.categorytype = categorytype;
		this.products = products;
	}

}
