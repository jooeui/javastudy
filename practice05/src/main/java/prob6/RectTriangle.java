package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;
	
	public RectTriangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	@Override
	public double getArea() {
		return (width * height) / 2 ;
	}

	@Override
	public double getPerimeter() {
		double hypotenuse = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		return width + height + hypotenuse;
	}

}
