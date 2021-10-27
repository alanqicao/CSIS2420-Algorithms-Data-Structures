package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;

/**
 * 
 * @author Qi Cao
 *
 * @param <Value>
 */
public class PointST<Value> {
	
		private final RedBlackBST<Point2D,Value> pointSymbolTable;
	
		/**
		 * construct an empty symbol table of points 
		 */
	   public PointST() {
		   pointSymbolTable = new RedBlackBST<Point2D,Value>();
	   }  
	   
	   /**
	    * is the symbol table empty? 
	    * @return
	    */
	   public boolean isEmpty() {
		return pointSymbolTable.isEmpty();
		   
	   } 
	   
	   /**
	    * number of points 
	    * @return
	    */
	   public int size() {
		return pointSymbolTable.size();
		   
	   }   
	   
	   /**
	    * associate the value val with point p
	    * @param p
	    * @param val
	    */
	   public void put(Point2D p, Value val) {
		   pointSymbolTable.put(p, val);
	   }
	   
	   /**
	    * value associated with point p 
	    * @param p
	    * @return
	    */
	   public Value get(Point2D p) {
		return pointSymbolTable.get(p);
		   
	   }
	   
	   /**
	    * does the symbol table contain point p? 
	    * @param p
	    * @return
	    */
	   public boolean contains(Point2D p) {
		return pointSymbolTable.contains(p);
		   
	   }
	   
	   /**
	    * all points in the symbol table 
	    * @return
	    */
	   public Iterable<Point2D> points(){
		   
		   Queue <Point2D> allPoints = new Queue<Point2D>();
		   
		   for(Point2D el: pointSymbolTable.keys()) {
			   allPoints.enqueue(el);
		   }
		return allPoints;
		   
	   }
	   
	   /**
	    * all points that are inside the rectangle 
	    * @param rect
	    * @return
	    */
	   public Iterable<Point2D> range(RectHV rect){
		   
		   
		return null;
		   
	   }
	   
	   /**
	    *  a nearest neighbor to point p; null if the symbol table is empty 
	    * @param p
	    * @return
	    */
	   public Point2D nearest(Point2D p) {
		   
		   return null;
	   }
	   
	   /**
	    * unit testing of the methods (not graded) 
	    * @param args
	    */
	   public static void main(String[] args) {
		   
	   } 
	   
	   
}
