//Ti-Yang Chang
package Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Containers.bigContainer;
import Containers.container;
import Containers.smallContainer;
import Items.item;

public class calculation {
	private ArrayList<order> orders; // the all orders
	
	

	public calculation() {
		orders = new ArrayList<order>();
	}
	
	public ArrayList<order> getOrders() {
		return orders;
	}



	public void setOrders(ArrayList<order> orders) {
		this.orders = orders;
	}
	
	public double totalVolume() {
		double totalVolume = 0;
		for (order theOrder: this.orders) {
			for(item theItem: theOrder.getItemsList()) {
				totalVolume += theItem.calculateVolume();
			}
		}
		
		return totalVolume;
	}
	
	public double totalWeight() {
		double totalWeight = 0;
		for (order theOrder: this.orders) {
			for(item theItem: theOrder.getItemsList()) {
				totalWeight += theItem.calculateVolume();
			}
		}
		
		return totalWeight;
	}
	
	/*
	 * calculate needed containers
	 * input: smallContainer: the object of the smallContainer
	 *        bigContainer: the object of the bigContainer
	 * output: arrayList which contains smallContainer and bigContainer.
	 */
	public ArrayList<container> bestShippingMethod(smallContainer smallContainer, bigContainer bigContainer) {
		ArrayList<container> result = new ArrayList<container>(); //the result of the shipping method
		
		//read all items from all orders
		ArrayList<item> allItems = new ArrayList<item>();
		for (order theOrder: this.orders) {
			for(item theItem: theOrder.getItemsList()) {
				allItems.add(theItem);
			}
		}
		
		
		//sort all items by the item's area for shipping
		Collections.sort(allItems, new Comparator<item>() {

			@Override
			public int compare(item o1, item o2) {
				return (int)(o2.calculateShipItemArea() - o1.calculateShipItemArea());
			}
			
		});
		

		
		double shipL, shipW, shipH; 
		int containerB; //the need of the big containers
		/*
		 * the way to put the next item into the container
		 * 0: put the item at the bottom of the low left
		 * 1: put the item next to the previous item
		 * 2: put the item up left
		 */
		int layout; 
		int currentItemNum = allItems.get(0).getNumber();
		shipL = 0;
		shipW = 0;
		shipH = 0;
		containerB = 1;
		layout = 0;
		
		
		
		//compare the area of the items, then put the bigger item first
		while (currentItemNum > 0) {
			switch (layout) {
			    case 0:
					shipW = allItems.get(0).shipItemWidth();
					shipH = allItems.get(0).shipItemHeight();
					shipL = shipL + allItems.get(0).shipItemLength();
					
					//check the space for the next item
					if ((bigContainer.getWidth() - shipW) < allItems.get(0).shipItemWidth()) {
						if ((bigContainer.getHeight() - shipH) < allItems.get(0).shipItemHeight()) {
							shipW = 0;
							shipH = 0;
							layout = 0;
							break;
						}
						
						shipW = 0;
						layout = 2;
						break;
					}
					
					layout = 1;
			    	break;
			    case 1:
					shipW = shipW + allItems.get(0).shipItemWidth();
					
					//check the space for the next item
					if ((bigContainer.getWidth() - shipW) < allItems.get(0).shipItemWidth()) {
						if ((bigContainer.getHeight() - shipH) < allItems.get(0).shipItemHeight()) {
							shipW = 0;
							shipH = 0;
							layout = 0;
							break;
						}
						
						shipW = 0;
						layout = 2;
						break;
					}
					
					layout = 1;
			    	break;
			    case 2:
					shipW = allItems.get(0).shipItemWidth();
			    	shipH = shipH + allItems.get(0).shipItemHeight();
			    	
					//check the space for the next item
					if ((bigContainer.getWidth() - shipW) < allItems.get(0).shipItemWidth()) {
						if ((bigContainer.getHeight() - shipH) < allItems.get(0).shipItemHeight()) {
							shipW = 0;
							shipH = 0;
							layout = 0;
							break;
						}
						
						shipW = 0;
						layout = 2;
						break;
					}
					
					layout = 1;
			    	break;
			}
				
					

			//check if the container is full
			if (shipL > bigContainer.getLength()) {
				containerB = containerB + 1;
				shipW = 0;
				shipH = 0;
				shipL = 0;
				layout = 0;
				System.out.println("containerB: " + containerB);
				continue;
			}
			
			currentItemNum -= 1;
			
			//check all items are loaded
			if (currentItemNum == 0){
				allItems.remove(0);
				
				if (allItems.size() == 0){
					break;
				}else {
					currentItemNum = allItems.get(0).getNumber();
					shipW = 0;
					shipH = 0;
					layout = 0;
				}
			}
			
		}
		
		smallContainer.setNumber(0);
		smallContainer.setWeight(0);
		bigContainer.setNumber(containerB);
		
		result.add(smallContainer);
		result.add(bigContainer);
		
		return result;
	}
	
	public int shippingPrice(ArrayList<container> result) {
		return result.get(0).getCost() * result.get(0).getNumber() + result.get(1).getCost() * result.get(1).getNumber();
	}
	
	//put the new item into the last order
	public void addItems(item newItem) {
		if (this.orders.size() > 0) {
			order lastOrder = this.orders.get(this.orders.size() - 1);
			lastOrder.getItemsList().add(newItem);
		}else {
			order newOrder = new order();
			newOrder.getItemsList().add(newItem);
			this.orders.add(newOrder);
		}
	}
	
	//put the new order into order list
	public void addOrder(order newOrder) {
		this.orders.add(newOrder);
	}
	
	//print all items of the order
    public void printItemsInfo(order theOrder) {
    	theOrder.printOrderInfo();
    }
    
    
    //print all orders
    public void printOrderInfo() {
    	for (order theOrder: this.orders) {
    		theOrder.printOrderInfo();
    	}
    }
    
    //get all orders' information
    public String getOrderInfo() {
    	String result = "";
    	for (order theOrder: this.orders) {
    		result = result + theOrder.getOrderInfo();
    	}
    	
    	return result;
    }


	
}
