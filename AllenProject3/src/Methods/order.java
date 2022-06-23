//Ti-Yang Chang
package Methods;

import java.util.ArrayList;

import Items.item;

// one order has many items
public class order {
	private ArrayList<item> itemsList; //the items of the order
	private int orderNumber; //the number of the order
	private static int orderNumbers = 0; // the accumulation number of all orders
	
	public order() {
		this.itemsList = new ArrayList<item>();
		orderNumbers++;
		this.orderNumber = orderNumbers;
	}

	
	
	//Getters and setters
	public ArrayList<item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(ArrayList<item> itemsList) {
		this.itemsList = itemsList;
	}
	
	
	
	public void printOrderInfo() {
		System.out.println("order number: " + this.orderNumber);
		for (item theItem: this.itemsList) {
			theItem.printItemInfo();
		}
	}
	
	public String getOrderInfo() {
		String result = "order number: " + this.orderNumber + "\n";
		for (item theItem: this.itemsList) {
			result = result +theItem.getItemInfo();
		}
		
		return result;
	}
	
	

}
