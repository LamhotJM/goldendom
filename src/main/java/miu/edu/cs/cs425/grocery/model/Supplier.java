package miu.edu.cs.cs425.grocery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "suppliers")
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	private int supplierNumber;
    private String name;
    private String contactPhoneNumber;
    // one to many which means one supplier will have many products
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    
    private List<Product> products = new ArrayList<>();
    
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Supplier(int supplierNumber, String name, String contactPhoneNumber) {
		super();
		this.supplierNumber = supplierNumber;
		this.name = name;
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public Supplier() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getSupplierId() {
		return supplierId;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierNumber=" + supplierNumber + ", name=" + name
				+ ", contactPhoneNumber=" + contactPhoneNumber + ", products=" + products + "]";
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(int supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

}
