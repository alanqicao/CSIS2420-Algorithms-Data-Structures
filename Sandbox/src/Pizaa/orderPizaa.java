/**
 * 
 */
package Pizaa;

import java.util.Scanner;

/**
 * @author caose_000
 *
 */
public class orderPizaa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		 Scanner sc = new Scanner(System.in);
		 
	     int peoples = sc.nextInt();
	     
	     int pizzaSla = peoples * 2;
	     
	     double pizaa = pizzaSla / 12;
	     System.out.println("Enter people");
	     System.out.println(pizaa);
	     
	}

}
