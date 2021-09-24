/**
 * 
 */
package a02;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author caose_000
 *
 */
public class Subset {
	


	 
	   public static void main(String[] args) {
		   	 int argInt = Integer.parseInt(args[0]);
		   	 
			 RandomizedQueue <String> randQueue = new RandomizedQueue<String>();
			 
			 while(!StdIn.isEmpty()) {
				 randQueue.enqueue(StdIn.readString());
			 }
			 

			 for(int i=0; i<argInt;i++) {
				 System.out.println(randQueue.dequeue());
			 }
		   
	   }
	   
	}