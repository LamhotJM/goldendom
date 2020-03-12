package miu.edu.cs.cs425.grocery.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.cs.cs425.grocery.model.Supplier;
import miu.edu.cs.cs425.grocery.repository.SupplierRepository;
import miu.edu.cs.cs425.grocery.service.SupplierService;

@Transactional
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository supplierRepository;
	
	
	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	@Override
	public Supplier save(Supplier studentRegistration) {
		// TODO Auto-generated method stub
		return supplierRepository.save(studentRegistration);
	}

	@Override
	public Supplier findOne(Integer id) {
		// TODO Auto-generated method stub
		return supplierRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		supplierRepository.deleteById(id);
		
	}
	

}
