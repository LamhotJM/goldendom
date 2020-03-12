package miu.edu.cs.cs425.grocery.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.cs.cs425.grocery.model.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

	
	//
}
