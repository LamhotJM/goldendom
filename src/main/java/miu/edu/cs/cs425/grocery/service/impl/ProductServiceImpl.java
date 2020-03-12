package miu.edu.cs.cs425.grocery.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.cs.cs425.grocery.model.Product;
import miu.edu.cs.cs425.grocery.repository.ProductRepository;
import miu.edu.cs.cs425.grocery.service.ProductService;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product save(Product studentRegistration) {
		// TODO Auto-generated method stub
		return productRepository.save(studentRegistration);
	}

	@Override
	public Product findOne(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

}
