/**
 * 
 */
package midter1;

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
	
//		
//		for(int i = 0; i < s.size();i++) {
//			
//			newString.push(s.peek());
//			
//		}
		
	
		while(!s.isEmpty()) {
			
			newString.push(s.pop());
			
		}
		
		
		System.out.println("newString "+newString);
		System.out.println(s);
			
		if(size == 1 || newString.peek().matches("\\d+") ) {
			
			newString.pop();
			newString.push("?");
			
		}
			
		while(!newString.isEmpty()){
			
			if(newString.peek().endsWith("_")) {
				
				newString.pop();
			}
			newQueue.enqueue(newString.peek());
			newQueue.enqueue(newString.pop().toUpperCase());		
			
		}
	
		return newQueue; 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 Stack<String> s = new Stack<>();
		   s.push("_");
		   s.push("a");
		   s.push("b");
		   s.push("c");
		   
		   
		 
		   StdOut.println(s + "=> " + transform(s)); // expected output: c b a => c C b B a A
		   StdOut.println("old S= "+s);
	}

}
