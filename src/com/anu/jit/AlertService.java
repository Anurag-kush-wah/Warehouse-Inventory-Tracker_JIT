package com.anu.jit;

public class AlertService implements StockObserver {

	@Override
	public void onLowStock(Product p) {
		// TODO Auto-generated method stub
       System.out.println("ALERT: Low stock for " + p.getName() + " (Only " + p.getQuantity() + "left)");
	}

}
