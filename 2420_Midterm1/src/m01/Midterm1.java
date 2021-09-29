/**
 * 
 */
package m01;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Qi Cao
 *
 */
public class Midterm1 {
	
	public static Iterable<String> transform(Stack<String> s){
			
		Stack<String> newString = new Stack<>();
		Queue<String> newQueue = new Queue<>();
		
		int size = s.size();
		
		while(!s.isEmpty()) {
			
			newString.push(s.peek());
			
			
		}
		
			
		if(size == 1 || newString.peek().matches("\\d+") ) {
			newString.pop();
			newString.push("?");
		}
			
		while(!newString.isEmpty()) {
			
			if(newString.peek().startsWith("_")) {
				newString.pop();
			}
			
			newString.push(newString.peek().toUpperCase());
			
			
			
		}
		
		
		
		
		return newString; 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 Stack<String> s = new Stack<>();
		   s.push("a");
		   s.push("b");
		   s.push("c");
		 
		   StdOut.println(s + "=> " + transform(s)); // expected output: c b a => c C b B a A
	}

}
