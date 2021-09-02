package comparable;

public class Rectangle implements Comparable<Rectangle>{
	private double height;
	private double width;
	public Rectangle(double height, double width) {
		
		this.height = height;
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}
	@Override
	public int compareTo(Rectangle other) {
		
		return Double.compare(this.height, other.height);
	}
	

}
