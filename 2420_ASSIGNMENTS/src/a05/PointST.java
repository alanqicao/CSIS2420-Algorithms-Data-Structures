package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;

/**
 * Mutable data type implementation red-black BST for 2d points
 * @author Qi Cao and Peter Kingston
 *
 * @param <Value>
 */
public class PointST<Value> {
	
	  private final RedBlackBST<Point2D,Value> pointSymbolTable;
	
		/**
		 * Construct an empty symbol table of points 
		 */
	   public PointST() {
		   pointSymbolTable = new RedBlackBST<Point2D,Value>();
	   }  
	   
	   /**
	    * Is the symbol table empty? 
	    * @return True if table is empty otherwise false
	    */
	   public boolean isEmpty() {
		return pointSymbolTable.isEmpty();
		   
	   } 
	   
	   /**
	    * Returns the number of the points 
	    * @return number of points
	    */
	   public int size() {
		return pointSymbolTable.size();
		   
	   }   
	   
	   /**
	    * Associate the value with point p
	    * @param p key point
	    * @param val value
	    */
	   public void put(Point2D p, Value val) {
		   if(p == null||val ==null) {
			   throw new java.lang.NullPointerException();
		   }
		   pointSymbolTable.put(p, val);
	   }
	   
	   /**
	    * Return the value associated with the given key
	    * @param p key
	    * @return Value associated with key
	    */
	   public Value get(Point2D p) {
		   if(p==null) {
			   throw new java.lang.NullPointerException ();
		   } 
		   
		return pointSymbolTable.get(p);
		   
	   }
	   
	   /**
	    * Does the symbol table contain point p? 
	    * @param p the key
	    * @return True if contain otherwise false.
	    */
	   public boolean contains(Point2D p) {
		   if(p==null) {
			   throw new java.lang.NullPointerException ();
		   } 
		   
		return pointSymbolTable.contains(p);
		   
	   }
	   
	   /**
	    * Returns all points in the symbol table 
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
	    * Return all points that are inside the rectangle 
	    * @param rect given rectangle
	    * @return
	    */
	   public Iterable<Point2D> range(RectHV rect){
		   
		   if(rect==null) {
			   throw new java.lang.NullPointerException ();
		   } 
		   
		   Queue<Point2D> insideRactangle = new Queue<Point2D>();
		   
		   for(Point2D el: pointSymbolTable.keys()) {
			  if(rect.contains(el)) {
				  insideRactangle.enqueue(el);
			  }
		   }
		   
		return insideRactangle;
		   
	   }
	   
	   /**
	    *  Return a nearest neighbor to given point p;  
	    * @param p point key
	    * @return nearest point null if the symbol table is empty
	    */
	   public Point2D nearest(Point2D p) {
		   
		   if(p==null) {
			   throw new java.lang.NullPointerException ();
		   } 
		   
		   Double smallest = Double.MAX_VALUE;
		   Point2D smallestPoint = p;
		   
		   for(Point2D el: pointSymbolTable.keys()) {			   
			 if(el.distanceTo(p) < smallest) {			 
				 smallest = el.distanceTo(p);			 
				 smallestPoint = el;
			 }			   
		   }		   
		   return smallestPoint;
	   }
	   
	   /**
	    * testing 
	    * @param args
	    */
	   public static void main(String[] args) {
		   
		   PointST <Integer> pointSt;
		   RectHV rectangle = new RectHV(0.5,0.5,0.8,0.9);
		   System.out.println("pint[(0,0),(0,0)] distance to rectangle is: "+ rectangle.distanceTo(new Point2D(0.0,0.0)));
		   
		   pointSt = new PointST<Integer>();
		   //test is empty
		   System.out.println("Is empty?: "+pointSt.isEmpty()); 
		   //test put
		   pointSt.put(new Point2D(0,4), 0);
		   pointSt.put(new Point2D(5,0), 2);
		   pointSt.put(new Point2D(6,9), 4);
		   pointSt.put(new Point2D(-3,4), 9);
		   //test get
		   System.out.println("Get value of 5,0 = "+pointSt.get(new Point2D(5,0)));
		   //test size
		   System.out.println("Size: "+pointSt.size()); 
		   //test contian
		   System.out.println("test contian pint (0,4): "+pointSt.contains(new Point2D(0,4))); 
		   //test all point each point
		   System.out.println("Test all point:");
		   for(Point2D el: pointSt.points()) {
			   System.out.println(el.toString());
		   }
		   
		   //test range
		   System.out.println("Test range rectangle -3,-4,8,6: "+ pointSt.range(new RectHV(-3,-4,8,6)));
		   //test nearest
		   System.out.println("Test nearest point (1,1): "+ pointSt.nearest(new Point2D(1,1)));
		   
		   
		   
	   } 
	   
	   
}
