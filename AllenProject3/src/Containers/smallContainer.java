//Ti-Yang Chang
package Containers;

public class smallContainer extends container{
	private double weight; //kg
	private int cost; //euro
	
	public smallContainer(double length, double width, double height, int number, double weight) {
		super(length, width, height, number);
		if (weight > 500) {
			this.cost = 1200;
		}else {
			this.cost = 1000;
		}
	}



	//Getters and setters
	public double getWeight() {
		return weight;
	}





	public void setWeight(double weight) {
		this.weight = weight;
	}





	public int getCost() {
		return cost;
	}





	public void setCost(int cost) {
		this.cost = cost;
	}



	@Override
	public void printContainerInfo() {
		System.out.println("length: " + super.getLength());
		System.out.println("width: " + super.getWidth());
		System.out.println("height: " + super.getHeight());
		System.out.println("weight: " + this.weight);
		System.out.println("cost: " + this.cost);
	}

}
