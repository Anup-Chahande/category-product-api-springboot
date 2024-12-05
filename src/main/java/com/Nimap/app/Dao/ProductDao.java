package com.Nimap.app.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Nimap.app.Entity.Product;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sf;

	public List<Product> getallproductsandcategory() {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Product.class);
		c.setFirstResult(0);
		c.setMaxResults(5);
		List<Product> ls = c.list();
		
		
		return ls;

	
	}

	public void addproducts(Product product) {
		Session s = sf.openSession();
		s.save(product);
		Transaction t = s.beginTransaction();
		t.commit();

	}

	public void updateProducts(Product product) {
		Session s = sf.openSession();
		s.update(product);
		Transaction t = s.beginTransaction();
		t.commit();
	}

	public void deleteproduct(int id) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Product.class);
		List<Product> ls = c.list();
		ArrayList<Product> lp = new ArrayList<Product>();
		for (Product product : ls) {

			if (id == product.getPid()) {
				Product p1 = new Product(id, product.getPname(), product.getPrice(), product.getPname(),
						product.getCategory());
				p1 = (Product) s.merge(p1);
				s.delete(p1);
				Transaction t = s.beginTransaction();
				t.commit();
			}
		}

	}

	public List<Product> getallproductsandcategorybyid(int id) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Product.class);
		c.setFirstResult(0);
		c.setMaxResults(5);
		List<Product> lp = c.list();
		return lp;
	}

}
