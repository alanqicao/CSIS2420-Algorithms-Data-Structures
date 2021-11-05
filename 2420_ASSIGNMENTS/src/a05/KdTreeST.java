/**
 * 
 */
package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * @author 
 *
 */
public class KdTreeST<Value> {
	
	private Node root;
	
	
	private class Node {
		   private Point2D p;      // the point
		   private Value value;    // the symbol table maps the point to this value
		   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
		   private Node lb;        // the left/bottom subtree
		   private Node rt;        // the right/top subtree
		   
		}
	
	
	
	isEmpty() 
	
	size()
	
	//search
	 public Value get(Key key)
	 
	private Value get(Node x, Key key) {
		  if (x == null) return null;

		  int cmp = key.compareTo(x.key);
		  if      (cmp < 0) return get(key, x.left);
		  else if (cmp > 0) return get(key, x.right);
		  else              return x.value  
		}
	//insert
		public void put(Key key, Value val)
		private Node put(Node x, Key key, Value val)
		
		
		public boolean contains(Point2D key)
	
	//return the poiunts in level-order
	points()
	

	//find all points contained in a given query rectangle
	range()
	
	nearest()
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
