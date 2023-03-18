package com.example.demo.dto;

public class CartDTO {
	private int cart_id;
    public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	private String productName;
    private double price;
    private int quantity;
    private double total;
    private byte[] productImage;
    private String category;

    public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CartDTO(int cart_id,String productName, double price, int quantity, double total,byte[] productImage,String category) {
        this.category=category;
		this.productImage=productImage;
		this.cart_id=cart_id;
    	this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

    
}
