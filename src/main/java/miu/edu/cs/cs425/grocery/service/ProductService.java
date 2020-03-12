package miu.edu.cs.cs425.grocery.service;

import java.util.List;

import miu.edu.cs.cs425.grocery.model.Product;


public interface ProductService {
	
	List<Product> findAll();
	Product save(Product produt);
	Product findOne(Long id);
	void delete(Long id);

}
