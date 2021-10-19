package ceMail;


import edu.princeton.cs.algs4.MinPQ;


/**
 * 
 * @author Qi Cao
 *
 */
public class DemoHeap {

		
	
	public static void main(String[] args) {
		
		
		MinPQ<Mail> mails = new MinPQ<>();
		
		
		
		for(int i = 0; i<25;i++) {
			
			Mail mail = new Mail();
			
			mails.insert(mail);
		}
		
		
		
		
		
		
		
	}

}
