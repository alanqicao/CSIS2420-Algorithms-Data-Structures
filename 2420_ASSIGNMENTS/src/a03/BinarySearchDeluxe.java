package a03;

import java.util.Comparator;

/**
 * Class that uses a Binary search algorithm to return the index</br>
 * of the first or last occurrence of a Key in the Key array.
 * 
 * @author Qi Cao, Samuel Bailey
 *
 */
public class BinarySearchDeluxe {

	/**
	 * Uses a binary search algorithm to return the index of the first occurrence of the desired <code>key</code>.
	 * 
	 * @param <Key> The objects that the array is made of
	 * @param a The array of Keys
	 * @param key The object in the array that we are searching for
	 * @param comparator The comparator used to compare the start, mid, and end values
	 * @return The index of the first occurrence of <code>key</code>
	 */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if(a == null || key == null || comparator == null) {
    		throw new NullPointerException("Data cannot be null");
    	}
    	
    	int start = 0;
    	int end = a.length-1;

    	if(comparator.compare(a[start], key)==0) {
    		return 0;
    	}
    	
    	while(start <= end) {
    		
    		int mid = start + (end - start )/2;
    		 		
    		if(comparator.compare(a[mid], key) < 0) {
    			end = mid - 1;
    		}else if(comparator.compare(a[mid], key) > 0) {
    			start = mid + 1;
    		}else if(comparator.compare(a[mid-1], a[mid])==0){
    			end = mid -1;
    		}else {
    			return mid;
    		}
    	}
    	

    	
    	return -1;
    }

	/**
	 * Uses a binary search algorithm to return the index of the last occurrence of the desired <code>key</code>.
	 * 
	 * @param <Key> The objects that the array is made of
	 * @param a The array of Keys
	 * @param key The object in the array that we are searching for
	 * @param comparator The comparator used to compare the start, mid, and end values
	 * @return The index of the last occurrence of <code>key</code>
	 */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if(a == null || key == null || comparator == null) {
    		throw new NullPointerException("Data cannot be null");
    	}
    	
    	int start = 0;
    	int end = a.length-1;

    	if(comparator.compare(a[end], key)==0) {
    		return end;
    	}
    	
    	while(start <= end) {
    		
    		int mid = start + (end - start )/2;
    		 		
    		if(comparator.compare(a[mid], key) < 0) {
    			end = mid - 1;
    		}else if(comparator.compare(a[mid], key) > 0) {
    			start = mid + 1;
    		}else if(comparator.compare(a[mid+1], a[mid])==0){
    			end = mid +1;
    		}else {
    			return mid;
    		}
    	}
    	

    	
    	return -1;
    }
}
