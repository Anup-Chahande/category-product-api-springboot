package com.Nimap.app.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Nimap.app.Entity.Category;

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory sf;

	public List<Category> getallcategory() {

		List<Category> cl=null;
		
		try(Session s = sf.openSession()){
		Criteria c = s.createCriteria(Category.class);

		c.setFirstResult(0);
		c.setMaxResults(5);
		 cl = c.list();

		}
		catch(Exception e) {}
		return cl;

	}

	public void addCategory(Category category) {
		Session s = sf.openSession();
		s.save(category);
		Transaction t = s.beginTransaction();
		t.commit();

	}

	public void updateCategory(Category category) {
		Session s = sf.openSession();
		s.update(category);
		Transaction t = s.beginTransaction();
		t.commit();
	}

	public void deleteCategory(int id) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Category.class);

		List<Category> cl = c.list();

		for (Category category : cl) {
			if (category.getCid() == id) {

				s.delete(category);
				Transaction t = s.beginTransaction();
				t.commit();

			}
		}

	}

	public List<Category> getcategorybyid(int id) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Category.class);
		c.setFirstResult(0);
		c.setMaxResults(5);
		List<Category> cl = c.list();
		
			
		
	return cl;
	}

}
