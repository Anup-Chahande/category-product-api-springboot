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

import com.Nimap.app.Entity.Product;
import com.Nimap.app.Service.ProductService;

@RestController
@CrossOrigin("http://localhost:4200/")

public class ProductControler {

	@Autowired
	ProductService ps;

	@GetMapping("/products")
	public List<Product> getallproductsandcategory() {

		return ps.getallproductsandcategory();

	}

	@PostMapping("/products")
	public void addproducts(@RequestBody Product product) {

		ps.addproducts(product);

	}

	@PutMapping("/products")
	public void updateProducts(@RequestBody Product product) {

		ps.updateProducts(product);

	}

	@DeleteMapping("/products/{id}")
	public void deleteproduct(@PathVariable int id) {

		ps.deleteproduct(id);

	}

	@GetMapping("/products/{id}")
	public Product getallproductsandcategorybyid(@PathVariable int id) {

		return ps.getallproductsandcategorybyid(id);

	}

}
