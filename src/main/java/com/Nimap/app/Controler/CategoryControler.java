package com.Nimap.app.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Nimap.app.Entity.Category;
import com.Nimap.app.Service.CategoryService;

@RestController
@CrossOrigin("http://localhost:4200/")

public class CategoryControler {

	@Autowired
	CategoryService cs;

	@GetMapping("/category")
	public List<Category> getallcategory() {

		return cs.getallcategory();

	}

	@PostMapping("/category")
	public void addCategory(@RequestBody Category category) {

		cs.addCategory(category);

	}

	@PutMapping("/category")
	public void updateCategory(@RequestBody Category category) {

		cs.updateCategory(category);

	}

	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable int id) {

		cs.deleteCategory(id);

	}
	
	@GetMapping("/category/{id}")
	public Category getcategorybyid(@PathVariable int id) {

		return cs.getcategorybyid(id);

	}

}
