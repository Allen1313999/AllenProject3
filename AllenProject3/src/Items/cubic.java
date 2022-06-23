//Ti-Yang Chang
package Items;

public class cubic extends item{
	private String shape;
	private double length; //cm
	private double width; //cm
	private double height; //cm
	
	public cubic(String name, double weight, int number, double length, double width, double height) {
		super(name, weight, number);
		this.shape = "cubic";
		this.length = length;
		this.width = width;
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





	@Override
	public double calculateVolume() {
		return this.length * this.width * this.height;
	}
	
	@Override
	public void printItemInfo() {
        System.out.println("name: " + super.getName());
        System.out.println("weight: " + super.getWeight());
        System.out.println("number: " + super.getNumber());
        System.out.println("shape: " + this.shape);
        System.out.println("length: " + this.length);
        System.out.println("width: " + this.width);
        System.out.println("height: " + this.height);
        System.out.println("volume: " + this.calculateVolume());
	}



	@Override
	public double calculateShipItemArea() {
		return this.length * this.width;
	}



	@Override
	public double shipItemLength() {
		return this.length;
	}



	@Override
	public double shipItemWidth() {
		return this.width;
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
		+ "width: " + this.width + "\n"
		+ "height: " + this.height + "\n"
		+ "volume: " + this.calculateVolume() + "\n";
		
		return result;
	}

}
