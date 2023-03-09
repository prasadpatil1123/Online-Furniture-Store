package com.example.demo.dto;

import com.example.demo.entities.Category;
import com.example.demo.entities.Seller;

public class ProductDTO {
	private int pid;
    private String pname;
    private String description;
    
    private byte[] productImage;
   
    private Seller seller;
    private Category category;
    
    
    
    
    
    
    
    
    
	public ProductDTO() {
		
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
    
    
}
