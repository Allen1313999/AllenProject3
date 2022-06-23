//Ti-Yang Chang
package Items;

public abstract class item {
	
	private String name;
	private double weight; //kg
	private int number; //the number of the item
	

	
	public item(String name, double weight, int number) {
		this.name = name;
		this.weight = weight;
		this.number = number;
	}
	
	
	




	//Getters and setters
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	//abstract methods
	public abstract double calculateVolume();
	
	public abstract void printItemInfo(); 	
	
	public abstract String getItemInfo(); 	
	
	//calculate the area of the item for shipping method
	public abstract double calculateShipItemArea();
	
	//return the length of the item for shipping method
	public abstract double shipItemLength();
	
	//return the width of the item for shipping method
	public abstract double shipItemWidth();
	
	//return the height of the item for shipping method
	public abstract double shipItemHeight();
}
