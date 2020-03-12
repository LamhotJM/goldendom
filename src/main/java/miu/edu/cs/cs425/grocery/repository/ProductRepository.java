package miu.edu.cs.cs425.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.cs.cs425.grocery.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	
	//
}
