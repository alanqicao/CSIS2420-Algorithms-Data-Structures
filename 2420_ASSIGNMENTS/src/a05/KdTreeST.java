/**
 * 
 */
package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdOut;

/**
 * Mutable data type KdTreeST using BST with points in the nodes and X and y coordinates of the points
 * @author Qi Cao and Peter Kingston
 *
 */
public class KdTreeST<Value> {
	
	private Node root;
	private int size = 0;
	private int level = 0;
	
	/**
	 * Helper class nodes
	 * @author Qi Cao and Peter Kingston
	 *
	 */
	private class Node {
		   private Point2D key;      // the point
		   private Value value;    // the symbol table maps the point to this value
		   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
		   private Node lb;        // the left/bottom subtree
		   private Node rt;        // the right/top subtree
		   private Node(Point2D key, Value val, RectHV rect) {
			   if(key == null) {
					throw new java.lang.NullPointerException("key can not be null!");
				}
			   if(val == null) {
					throw new java.lang.NullPointerException("Value can not be null!");
				}
			   if(rect == null) {
					throw new java.lang.NullPointerException("Rectangle can not be null!");
				}
			   this.key = key;
			   this.value = val;
			   this.rect = rect;
		   }
		}
	
	
	/**
	 * Returns true if this symbol table is empty
	 * @return if symbol table is empty return true otherwise false.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Returns the number of the key value pairs in this symbol table
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Insets the specified key-value pair into the symbol table base on X and Y coordinates
	 * @param key the key
	 * @param val the value
	 */
	public void put(Point2D key, Value val) {
		if(key == null) {
			throw new java.lang.NullPointerException("key can not be null!");
		}
		if(val == null) {
			throw new java.lang.NullPointerException("Value can not be null!");
		}
		if(isEmpty()) {
			root = new Node(key, val, new RectHV(Double.NEGATIVE_INFINITY,
					Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY));
			size++;
		}else {			
			put(root,key,val,root);
			
		}
		
	}
	
	/**
	 * Helper method for put if symbol table is not empty
	 * @param x current node
	 * @param key the key
	 * @param val the value
	 * @param parent the parent node
	 * @return node
	 */
	private Node put(Node x, Point2D key, Value val,Node parent) {	
		if(key == null) {
			throw new java.lang.NullPointerException("key can not be null!");
		}
		if(val == null) {
			throw new java.lang.NullPointerException("Value can not be null!");
		}
		if(parent == null) {
			throw new java.lang.NullPointerException("Parent can not be null!");
		}
		if (x == null) {
			size++;
			return new Node(key, val, newRectangle(key, parent));
			
		}
		double cmp = key.compareTo(x.key);
		if (cmp == 0) {
			x.value = val;
		} else {
			if (level % 2 == 0) {
				cmp = key.x() - x.key.x();
			} else {
				cmp = key.y() - x.key.y();
			}
			level++;
			if (cmp < 0) {
				x.lb = put(x.lb, key, val, x);
			} else {
				x.rt = put(x.rt, key, val, x);
			}
		}
		return x;
	}
	
	
	/**
	 * Helper method to sets up rectangle for each node
	 * @param key the key
	 * @param parent parent node
	 * @return
	 */
	private RectHV newRectangle(Point2D key, Node parent) {		
		if(key == null) {
			throw new java.lang.NullPointerException("key can not be null!");
		}
		if(parent == null) {
			throw new java.lang.NullPointerException("Parent can not be null!");
		}
		double xMin, xMax, yMin, yMax;
		if(level % 2 ==0) {
			xMin = parent.rect.xmin();
			xMax = parent.rect.xmax();
			if(key.y()>parent.key.y()) {
				yMin = parent.key.y();
				yMax = parent.rect.ymax();
			}else {
				yMin = parent.rect.ymin();
				yMax = parent.key.y();
			}
		}else {
			yMin = parent.rect.ymin();
			yMax = parent.rect.ymax();
			if(key.x()>parent.key.x()) {
				xMin = parent.key.x();
				xMax = parent.rect.xmax();
			}else {
				xMin = parent.rect.xmin();
				xMax = parent.key.x();
			}
		}
		return new RectHV(xMin,yMin,xMax,yMax);
	}
	
	
	
	/**
	 * Return the value associated with the given key
	 * @param key the key
	 * @return
	 */
	 public Value get(Point2D key) {
			if(key == null) {
				throw new java.lang.NullPointerException("key can not be null!");
			}
		 return get(root,key);
	 }
	 

	 /**
	  * helper method for get method
	  * @param x
	  * @param key
	  * @return
	  */
		private Value get(Node x, Point2D key) {
			if(key == null) {
				throw new java.lang.NullPointerException("key can not be null!");
			}

			if (x == null) {
				level = 0;
				return null;
			}
			
			double cmp = key.compareTo(x.key);
			if (cmp == 0) {
				return x.value;
			} else {
				if (level % 2 == 0) {
					cmp = key.x() - x.key.x();
				} else {
					cmp = key.y() - x.key.y();
				}
				level++;
				if (cmp < 0) {
					return get(x.lb, key);
				}
				else{
					return get(x.rt, key);
				}
			}

		}
	 
	
	/**
	 * Does this symbol table contain the given key?
	 * @param key the key
	 * @return
	 */
	public boolean contains(Point2D key) {	
		if(key == null) {
			throw new java.lang.NullPointerException("key can not be null!");
		}
		return get(key)!=null;
	}
		
 

	/**
	 * Returns the keys in the points in level-order
	 * @return
	 */
	public Iterable<Point2D> points() {
		
		  Queue<Point2D> keys = new Queue<Point2D>();
	        Queue<Node> queue = new Queue<Node>();
	        
	        queue.enqueue(root);
	        while (!queue.isEmpty()) {
	            Node x = queue.dequeue();
	            if (x == null) continue;
	            keys.enqueue(x.key);
	            queue.enqueue(x.lb);
	            queue.enqueue(x.rt);
	        }
	        return keys;	
	}

	
	/**
	 * Return all points that contained in a given query rectangle
	 * @param rect the rectangle
	 * @return 
	 */
	public Iterable<Point2D> range(RectHV rect){	
		
		Queue<Point2D> points = new Queue<Point2D>();
		range(rect,points,root);
		//System.out.println("debug range: "+points);
		return points;
	}
	
	//helper method for recursively search for points 
	private void range(RectHV rect, Queue<Point2D> points,Node node) {
		if(rect == null) throw new java.lang.NullPointerException("Rectangle cannot be null!");
		if(node == null) throw new java.lang.NullPointerException("Node cannot be null!");
		
		if(rect.contains(node.key)) {
			points.enqueue(node.key);
		}
		if(node.lb != null  && rect.intersects(node.lb.rect)) {
			range(rect,points,node.lb);
			
		}
		if(node.rt !=null && rect.intersects(node.rt.rect)) {
     		range(rect, points, node.rt);
		}
	}
	
	/**
	 * Find closest point to a given query point 
	 * @return closet point
	 */
	public Point2D nearest(Point2D key) {
		if(key == null) {
			throw new NullPointerException();
		}
		
		Point2D nearestPoint = root.key;
		
		return nearest(key, root, nearestPoint);
	}
	
	//helper method for search both subtrees
	private Point2D nearest(Point2D key, Node node,Point2D nearestPoint) {
		
		if(node == null) {
			return nearestPoint;
		}
		if(node.rect.distanceSquaredTo(key) > nearestPoint.distanceSquaredTo(key)) {
			return nearestPoint;
		}
		if(key.distanceSquaredTo(node.key) < key.distanceSquaredTo(nearestPoint)) {
			nearestPoint= node.key;		
		}
		
		if(node.lb !=null && node.lb.rect.contains(key)) {
			nearestPoint = nearest(key,node.lb,nearestPoint);
			nearestPoint = nearest(key,node.rt,nearestPoint);
		}
		else if(node.rt !=null && node.rt.rect.contains(key)) {
			nearestPoint = nearest(key,node.rt,nearestPoint);
			nearestPoint = nearest(key,node.lb,nearestPoint);
		}
		
		
		return nearestPoint;
	}

	/**
	 * testing
	 * @param args
	 */
	public static void main(String[] args) {
		KdTreeST<Integer> testKdTreeST = new KdTreeST<Integer>();
		
		testKdTreeST.put(new Point2D(8,4), 0);
		testKdTreeST.put(new Point2D(5,3), 1);
		testKdTreeST.put(new Point2D(4,7), 2);
		testKdTreeST.put(new Point2D(4,0), 3);
		testKdTreeST.put(new Point2D(3,7), 4);
		testKdTreeST.put(new Point2D(-4,2), 5);
		testKdTreeST.put(new Point2D(-5,0), 6);
		
		//test get
		StdOut.println("Value at (8, 4): " + testKdTreeST.get(new Point2D(8, 4)));
		//test contain
		StdOut.println("Test contain (8, 4): "+testKdTreeST.contains(new Point2D(8, 4)));
		//test points
		StdOut.println("The points in level-order: " + testKdTreeST.points());
		//test range
		StdOut.println("PointST.range(new RectHV(0, 20, 0, 20)): " + testKdTreeST.range(new RectHV(-3, -5, 5, 7)));
		//test nearest
		StdOut.println("Nearest point to (2,3) is: "+testKdTreeST.nearest(new Point2D(2,3)));
	}

}
