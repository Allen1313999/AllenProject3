//Ti-Yang Chang
package Items;

public class cylindrical extends item{
	private String shape;
	private double radius; //cm
	private double height; //cm

	public cylindrical(String name, double weight, int number, double radius, double height) {
		super(name, weight, number);
		this.shape = "cylindrical";
		this.radius = radius;
		this.height = height;
	}

	
	
	//Getters and setters
	public String getShape() {
		return shape;
	}


	public void setShape(String shape) {
		this.shape = shape;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	
	@Override
	public double calculateVolume() {
		return this.radius * this.radius * Math.PI * this.height;
	}

	@Override
	public void printItemInfo() {
        System.out.println("name: " + super.getName());
        System.out.println("weight: " + super.getWeight());
        System.out.println("number: " + super.getNumber());
        System.out.println("shape: " + this.shape);
        System.out.println("radius: " + this.radius);
        System.out.println("height: " + this.height);
        System.out.println("volume: " + this.calculateVolume());
	}



	@Override
	public double calculateShipItemArea() {
		return this.radius * 2 * this.radius * 2;
	}



	@Override
	public double shipItemLength() {
		return this.radius * 2;
	}



	@Override
	public double shipItemWidth() {
		return this.radius * 2;
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
		+ "radius: " + this.radius + "\n"
		+ "height: " + this.height + "\n"
		+ "volume: " + this.calculateVolume() + "\n";
		
		return result;
	}
}
