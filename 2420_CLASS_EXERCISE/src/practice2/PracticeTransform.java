/**
 * 
 */
package practice2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 	//-----------------------------------------------------------------------------
	//practice 2
	// practices how to transform a stack that has been passed as an argument.
 * @author caose_000
 *
 */
public class PracticeTransform {

	/**
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("there");
		
		
		StdOut.println("original stack: "+ stack);
		transform(stack);
		StdOut.println("original stack: "+ stack);
	}

	public static void transform(Stack<String> s) {
		
		Queue<String> q = new Queue<>();
		
		// pops all elements, removes periods and commas, and puts the updated words in s2
		while(!s.isEmpty()) {
			
			String word = s.pop();
			char lastChar = word.charAt(word.length()-1);
			if(lastChar == ',' || lastChar == '.') {
				word = word.substring(0, word.length()-1); //remove punctuation
			}
			q.enqueue(word);
		}
		
		for(String el: q) {
			s.push(el);			
		}
		for(String el: q) {
			s.push(el);			
		}
		
	}
}
