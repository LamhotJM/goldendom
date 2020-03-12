package miu.edu.cs.cs425.grocery.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	// which means many products will relate to one supplier
    // adding new column on many tables(products)
	@ManyToOne()
	@JoinColumn(name = "supplier_id", nullable = true)
	private Supplier supplier;
	 
	public Product() {
		super();
		
	}
	public Product(Long productNumber, String name, Float unitPrice, int quantityInStock, LocalDate dateSupplied) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplied = dateSupplied;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public LocalDate getDateSupplied() {
		return dateSupplied;
	}
	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Product(Long productId, Long productNumber, String name, Float unitPrice, int quantityInStock,
			LocalDate dateSupplied) {
		super();
		this.productId = productId;
		this.productNumber = productNumber;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplied = dateSupplied;
	}
	private Long productNumber;
	private String name;
	private Float unitPrice;
    private int quantityInStock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSupplied;

}
