/**
 * 
 */
package ceStable;

import java.util.Comparator;

/**
 * Represents a rectangle that is defined by its length and width.
 * <br/>
 * 123
 * @author Qi Cao
 *
 */
public class Rectangle implements Comparable<Rectangle>{
	
	private int length;
	private int width;
	
	public static final Comparator<Rectangle> BY_AREA = new CompareByArea();
	
	
	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}


	public int getLength() {
		return length;
	}
	
/**
 * 
 * @return
 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return
	 */
	public int perimeter() {
		
		return 2 * length + 2 * width;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int area() {
		return length * width;
	}


	@Override
	public String toString() { 	
		return "[" + length + ","+ width + "]";
	}


	@Override
	public int compareTo(Rectangle other) {	
		return this.length-other.length;
		// return Integer.compare(this.length, other.length)
	}
	
	private static class CompareByArea implements Comparator<Rectangle>{

		@Override
		public int compare(Rectangle r1, Rectangle r2) {
	
			return Integer.compare(r1.area(), r2.area());
		}			
	}	
}
