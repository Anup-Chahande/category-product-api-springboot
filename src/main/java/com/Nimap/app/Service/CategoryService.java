package com.Nimap.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nimap.app.Dao.CategoryDao;
import com.Nimap.app.Entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao cd;

	public List<Category> getallcategory() {

		return cd.getallcategory();

	}

	public void addCategory(Category category) {
		cd.addCategory(category);
	}

	public void updateCategory(Category category) {

		cd.updateCategory(category);
	}

	public void deleteCategory(int id) {

		cd.deleteCategory(id);
	}

	public Category getcategorybyid(int id) {
		List<Category>ca=cd.getcategorybyid(id);
		for (Category category : ca) {
			if(category.getCid()==id) {
				
				return category;
			}
		}
		
		return null;
	}

}
