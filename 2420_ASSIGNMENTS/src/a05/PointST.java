package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;

/**
 * 
 * @author Qi Cao and Peter Kingston
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
		   if(p == null||val ==null) {
			   throw new java.lang.NullPointerException();
		   }
		   pointSymbolTable.put(p, val);
	   }
	   
	   /**
	    * value associated with point p 
	    * @param p
	    * @return
	    */
	   public Value get(Point2D p) {
		   if(p==null) {
			   throw new java.lang.NullPointerException ();
		   } 
		return pointSymbolTable.get(p);
		   
	   }
	   
	   /**
	    * does the symbol table contain point p? 
	    * @param p
	    * @return
	    */
	   public boolean contains(Point2D p) {
		   if(p==null) {
			   throw new java.lang.NullPointerException ();
		   } 
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
	    *  a nearest neighbor to point p; null if the symbol table is empty 
	    * @param p
	    * @return
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
	    * unit testing of the methods (not graded) 
	    * @param args
	    */
	   public static void main(String[] args) {
		   
	   } 
	   
	   
}
