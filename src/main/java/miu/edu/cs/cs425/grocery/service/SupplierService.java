package miu.edu.cs.cs425.grocery.service;

import java.util.List;
import miu.edu.cs.cs425.grocery.model.Supplier;

public interface SupplierService {
	
	List<Supplier> findAll();
	Supplier save(Supplier produt);
	Supplier findOne(Integer id);
	void delete(Integer id);


}
