/**
 * 
 */
package midter1MakeUp;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * A Duplicate all multiples of 11
 * B Remove all numbers that are not 2-digit numbers
 * C reverse the order of the elements in the queue
 * D Only return first 10 elements
 * @author Qi Cao
 *
 */
public class Midtern1 {
	

	
	public static Iterable<Integer> transform(Queue<Integer>q){

		if (q == null)			
			return null;
		
		if (q.isEmpty()) {
			return q;
		}
	
		Queue<Integer> newQueue = new Queue<>();
		Stack<Integer> newStack = new Stack<>();
		
		for (Integer el : q) {
			
			Integer current = el;
			if (current < 100 && current >= 10) {
				newStack.push(current);
			}
			if (current % 11 == 0) {
				newStack.push(current);
			}
		}
		
		
		if (newStack.size() >= 10) {
			for (int i = 0; i < 10; i++) {
				newQueue.enqueue(newStack.pop());
			}

		} else {
			for (Integer el : newStack) {
				newQueue.enqueue(el);
			}
		}
		
		return newQueue;		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		
		q.enqueue(3);
		q.enqueue(10);
		q.enqueue(11);
		q.enqueue(15);
		q.enqueue(123);
		
		Iterable<Integer> results = transform(q);
		System.out.println("Queue begain:");
		for(Integer el: q) {
			System.out.print(el+" ");
		}
		System.out.println();
		System.out.println("Results:");
		for(Integer el: results) {
			System.out.print(el+" ");
		}
		
		System.out.println();
		Queue<Integer> qTest2 = new Queue<>();
		
		qTest2.enqueue(10);
		qTest2.enqueue(12);
		qTest2.enqueue(11);
		qTest2.enqueue(11);
		qTest2.enqueue(13);
		qTest2.enqueue(22);
		qTest2.enqueue(22);
		qTest2.enqueue(50);
		
		Iterable<Integer> results2 = transform(qTest2);
		System.out.println("Queue begain:");
		for(Integer el: qTest2) {
			System.out.print(el+" ");
		}
		System.out.println();
		System.out.println("Results:");
		for(Integer el: results2) {
			System.out.print(el+" ");
		}
		System.out.println("\nTest empty");
		Queue<Integer> qTest3 = new Queue<>();
		Iterable<Integer> results3 = transform(qTest3);
		System.out.println();
		for(Integer el: results3) {
			System.out.println(el+" ");
		}
		
//		System.out.println("Test null");
//		Iterable<Integer> results4 = transform(null);
//		System.out.println();
//		for(Integer el: results4) {
//			System.out.println(el+" ");
//		}
		
	}

}
