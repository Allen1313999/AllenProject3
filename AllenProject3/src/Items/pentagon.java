//Ti-Yang Chang
package Items;

public class pentagon extends item{
	private String shape;
	private double length; //side length //cm
	private double height; //cm

	public pentagon(String name, double weight, int number, double length, double height) {
		super(name, weight, number);
		this.shape = "pentagon";
		this.length = length;
		this.height = height;
	}
	
	

	//Getters and setters
	public String getShape() {
		return shape;
	}



	public void setShape(String shape) {
		this.shape = shape;
	}



	public double getLength() {
		return length;
	}



	public void setLength(double length) {
		this.length = length;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	@Override
	public double calculateVolume() {
		return this.length * this.length * 5 / 4 * Math.tan(54) * this.height;
	}

	@Override
	public void printItemInfo() {
        System.out.println("name: " + super.getName());
        System.out.println("weight: " + super.getWeight());
        System.out.println("number: " + super.getNumber());
        System.out.println("shape: " + this.shape);
        System.out.println("length: " + this.length);
        System.out.println("height: " + this.height);
        System.out.println("volume: " + this.calculateVolume());
	}



	@Override
	public double calculateShipItemArea() {
		return this.length * 2 * this.length * 2;
	}



	@Override
	public double shipItemLength() {
		return this.length * 2;
	}



	@Override
	public double shipItemWidth() {
		return this.length * 2;
	}



	@Override
	public double shipItemHeight() {
		return this.height;
	}



	@Override
	public String getItemInfo() {
		String result = "name: " + super.getName() + "\n"
		+ "weight: " + super.getWeight() + "\n" 
		+ "number: " + super.getNumber() + "\n"	
		+ "shape: " + this.shape + "\n"
		+ "length: " + this.length + "\n"
		+ "height: " + this.height + "\n"
		+ "volume: " + this.calculateVolume() + "\n";
		
		return result;
	}

}
