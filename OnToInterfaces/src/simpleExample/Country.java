package simpleExample;

public class Country implements Measurable{
	private String name;
	private double area;
	
	public Country(String name, double area) {
		this.name = name;
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}
	
	public double getMeasure() {
		return this.area;
	}
}
