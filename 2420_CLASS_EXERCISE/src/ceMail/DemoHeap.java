package ceMail;

import edu.princeton.cs.algs4.MaxPQ;

import edu.princeton.cs.algs4.StdOut;


/**
 * 
 * @author Qi Cao
 *
 */
public class DemoHeap {

	public static void main(String[] args) {

		MaxPQ<Mail> mails = new MaxPQ<>();

		StdOut.println("25 random mail objects:");
		StdOut.println("-----------------------");

		for (int i = 0; i < 25; i++) {

			Mail mail = new Mail();
			StdOut.println(mail);
			mails.insert(mail);

		}

		StdOut.printf("\nMail Delivery:\n");
		StdOut.println("--------------");
	

		while (!mails.isEmpty()) {

			StdOut.println(mails.delMax());

		}

	}

}
