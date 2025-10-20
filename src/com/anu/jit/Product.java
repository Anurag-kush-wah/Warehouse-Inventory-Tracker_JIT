package com.anu.jit;

// BLC
public class Product {
	private String id;
	private String name;
	private int quantity;
	private int threshold;
	public Product(String id, String name, int quantity, int threshold) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.threshold = threshold;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getThreshold() {
		return threshold;
	}
	
	public void increaseQuantity(int amt) {
        quantity += amt;
    }

    public void decreaseQuantity(int amt) {
        quantity -= amt;
    }
    
	@Override
	public String toString() {
		//return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", threshold=" + threshold + "]";
	 return String.format("%-10s %-15s %-10d %-10d", id, name, quantity, threshold);
    }
	}
	
