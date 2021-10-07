/**
 * 
 */
package ceStable;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

/**
 * Test client for Rectangle that demonst
 * 
 * @author Qi Cao
 *
 */
public class StableApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Rectangle [] rectangles = {
				new Rectangle(4,2),
				new Rectangle(3,5),
				new Rectangle(4,3),
				new Rectangle(6,2),
				new Rectangle(3,4),
				new Rectangle(4,4),
				new Rectangle(6,4),
				new Rectangle(12,2),
				new Rectangle(2,4),
				new Rectangle(4,6),
				new Rectangle(2,12)
		};
		
		//print elements of rectangle array
		//sort it 
		// print it again
		System.out.println("Demo not Stable Sort");
		System.out.println("=====================");
		System.out.println("rectangle: "+Arrays.toString(rectangles));
		
		Arrays.parallelSort(rectangles);
		
		System.out.println("Sorted by length"+Arrays.toString(rectangles));
		Selection.sort(rectangles, Rectangle.BY_AREA);
		System.out.println("[4 x 6 ], [2x12] show length in revers order");
		System.out.println();
		//but with sort by length first
		//sort array base on area, 
		//Arrays.parallelSort(rectangles,Rectangle.BY_AREA);
		
		
		System.out.println("Demo Stable Sort");
		System.out.println("=====================");
		System.out.println("rectangle: "+Arrays.toString(rectangles));
		Arrays.parallelSort(rectangles);
		System.out.println("Sorted by length"+Arrays.toString(rectangles));
		Insertion.sort(rectangles, Rectangle.BY_AREA);;
		
		System.out.println("Sorted by area"+Arrays.toString(rectangles));
		
	}

}
