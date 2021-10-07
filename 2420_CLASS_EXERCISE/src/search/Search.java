package search;

import java.lang.reflect.Array;

/**
 * Prvides algorithms to search keys in arrays of numbers.
 * 
 * @author Alan
 *
 */
public class Search {
	/**
	 * Identifies the first occurrence of element key in the array numbers and
	 * return its index. If key is not included in the array, the method returns -1.
	 * 
	 * @param number
	 * @param key
	 * @return
	 * @exception NullPointerExxception if array is null.
	 */
	public static int liner(int[] number, int key) {

		for (int i = 0; i < number.length; i++) {
			if (number[i] == key) {

				return i;

			}

		}
		return -1;

	}

	/**
	 * Identifies the first occurrence of element key in the array reference type
	 * and return its index. If key is not included in the array, the method returns
	 * -1.
	 * 
	 * @param a   array of reference type.
	 * @param key
	 * @return
	 * @exception NullPointerExxception if array is null.
	 */
	public static <T> int liner(T[] a, T key) {

		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(key)) {
			
				return i;
			}

		}
		return -1;

	}

	/**
	 * 
	 * If Key is not inclued in the array, the method returns -1
	 * 
	 * Must be sort it befour binary search
	 * 
	 * @param numbers
	 * @param key
	 * @return
	 */

	public static int binary(int[] numbers, int key) {
		
		return 0;
		
	}
	
	public static boolean binaryRecursive(int[] numbers, int key,int left, int right) {
		
		//recursive
		
		if(left > right) {
			
		  return false;	//when left move to right or other way it stop
		  
		}
		
		int mid = ( left + right ) / 2; // to prvent index overflow, left+(right-left)/2
		
		if(numbers[mid]==key) {
			
			return true;  //if just happen key is mid 
			
		}else if(key < numbers[mid]) {
			
			return binaryRecursive(numbers,key,left,mid - 1);
			
		}else {
			
			return binaryRecursive(numbers,key,mid + 1,right);
			
		}
		
		
	}
	
	public static boolean binaryIterative(int[] numbers, int key) {
		
		//Iterative
		
		int left = 0;
		int right = numbers.length-1;
		
		while(left <= right) {
		
		int mid = ( left + right ) / 2; // to prvent index overflow, left+(right-left)/2
		
		if(numbers[mid]==key) {
			return true;  //if just happen key is mid 
		}else if(key < numbers[mid]) {
			
			right = mid - 1;
			
		}else {
			
			left = mid + 1;
			
		}
		
		}
		
		return false;
	}

}
