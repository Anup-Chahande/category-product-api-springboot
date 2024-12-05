package com.Nimap.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nimap.app.Dao.ProductDao;
import com.Nimap.app.Entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao pd;

	public List<Product> getallproductsandcategory() {
		return pd.getallproductsandcategory();
	}

	public void addproducts(Product product) {

		pd.addproducts(product);
	}

	public void updateProducts(Product product) {

		pd.updateProducts(product);
	}

	public void deleteproduct(int id) {

		pd.deleteproduct(id);
	}

	public Product getallproductsandcategorybyid(int id) {

		List<Product> lp = pd.getallproductsandcategorybyid(id);
		for (Product product : lp) {
			if (product.getPid() == id) {

				return product;
			}

		}
		return null;
	}

}
