package com.anu.jit;

import java.util.Scanner;

public class WarehouseApp {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 Warehouse warehouse = new Warehouse("Main Warehouse");
		 
		 warehouse.addObserver(new AlertService());
		 
     while(true)
     {
    	 System.out.println("===== WAREHOUSE INVENTORY TRACKER =====");
    	 System.out.println("1. Add New Product");
         System.out.println("2. Receive Shipment (Increase Quantity)");
         System.out.println("3. Fulfill Order (Decrease Quantity)");
         System.out.println("4. View All Products");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         int choice=sc.nextInt();
        if(choice<=0)
        {
        	 System.out.println("Invalid input, try again");
         } 
     switch(choice)
     {
     case 1:
    	 System.out.print("Enter Product ID: ");
         String id = sc.nextLine();
         sc.nextLine();
         System.out.print("Enter Product Name: ");
         String name = sc.nextLine();
         System.out.print("Enter Initial Quantity: ");
         int qty = Integer.parseInt(sc.nextLine());
         System.out.print("Enter Reorder Threshold: ");
         int th = Integer.parseInt(sc.nextLine());
         warehouse.addProduct(new Product(id, name, qty, th));
         break;
         
         
     case 2:
    	 System.out.print("Enter Product ID: ");
         String id2 = sc.nextLine();
         sc.nextLine();
         System.out.print("Enter Quantity to Add: ");
         int addQty = Integer.parseInt(sc.nextLine());
         warehouse.receiveShipment(id2, addQty);
         break;
         
         

     case 3:
         System.out.print("Enter Product ID: ");
         String id3 = sc.nextLine();
         sc.nextLine();
         System.out.print("Enter Quantity to Fulfill: ");
         int subQty = Integer.parseInt(sc.nextLine());
         warehouse.fulfillOrder(id3, subQty);
         break;

     case 4:
         warehouse.showAllProducts();
         break;

     case 5:
         System.out.println("Exiting system... Goodbye");
         sc.close();
         return;
         
         
     default:
         System.out.println("Invalid choice. Try again");
     }
    }
  }

}
