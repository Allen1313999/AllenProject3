//Ti-Yang Chang
package Containers;

public abstract class container {
	private double width; //cm
	private double height; //cm
	private double length; //cm
	private int number; //the number of the containers
	
	
	




	public container(double length, double width, double height, int number) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.number = number;
	}
	
	
	
	//Getters and setters
    public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	public double calculateVolume() {
		return this.length * this.width * this.height;
	};
	
	public abstract void printContainerInfo();
	
	public abstract int getCost();

}
