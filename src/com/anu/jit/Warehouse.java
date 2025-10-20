package com.anu.jit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {

	 private String name;
	 
	 private Map<String,Product> inventory=new HashMap<>();
	 private List<StockObserver> observers=new ArrayList<>();
	
	 public Warehouse(String name) {
		super();
		this.name = name;
	}
	 
	 public void addObserver(StockObserver obs) {
	        observers.add(obs);
	    }
	 
	 public void addProduct(Product p)
	 {
		 if(inventory.containsKey(p.getId()))
		 {
			 System.out.println("❌ Product ID already exists!");
	            return;
		 }
		 inventory.put(p.getId(), p);
		 System.out.println("Product added successfully.");
	 }
	 
	 public void receiveShipment(String id, int qty) {
		 Product p = inventory.get(id);
		 if(p==null) {
			 System.out.println("Invalid product id");
			 return;
		 }
		p.increaseQuantity(qty);
		 System.out.println("Shipment received. New quantity: " + p.getQuantity());
	 }

	 public void fulfillOrder(String id, int qty) {
		 Product p = inventory.get(id);
		 if(p==null) {
			 System.out.println("Invalid Product ID");
	            return;
		 }
		 if (qty > p.getQuantity()) {
	            System.out.println("Not enough stock available!");
	            return;
	        }
		 p.decreaseQuantity(qty);
		 System.out.println("Order fulfilled. Remaining: " + p.getQuantity());
	 
	 if (p.getQuantity() < p.getThreshold()) {
         for (StockObserver obs : observers)
             obs.onLowStock(p);
     }
	 
  }
	 public void showAllProducts() {
		 if (inventory.isEmpty()) {
	            System.out.println("No products in inventory");
	            return;
	        }
		 System.out.println("\n----------------------------- INVENTORY -----------------------------");
	        System.out.printf("%-10s %-15s %-10s %-10s%n", "ID", "Name", "Quantity", "Threshold");
	        System.out.println("--------------------------------------------------------------------");
	        for (Product p : inventory.values())
	            System.out.println(p);
	        System.out.println("--------------------------------------------------------------------");
	    }
	 }
