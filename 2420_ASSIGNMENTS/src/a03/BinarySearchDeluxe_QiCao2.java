package a03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Binary search class that search first and last index match the key
 * @author Qi Cao
 *
 */
public class BinarySearchDeluxe_QiCao2 {

	
	/**
	 * Binary Search the index of first key equals the search key, return -1 if not find.
	 * @param <Key> The class of the objects in the array.
	 * @param a the array to be searched.
	 * @param key the value key to be searched for.
	 * @param comparator .
	 * @return Index of the search key, if not fined return -1.
	 */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if(a == null || key == null || comparator == null) {
    		throw new NullPointerException("Data cannot be null");
    	}
    	
    	int start = 0;
    	int end = a.length;
    	int mid = 0;
    	int firstIndex = -1;
    	
		while (start <= end) {
			
			mid = (start + end) / 2;
			
			if (mid >= a.length) {
				mid -= 1;
			} else if (mid < 0) {
				mid += 1;
			}
			
			if (comparator.compare(a[mid], key) < 0) {
				start = mid + 1;
			} else if (comparator.compare(a[mid], key) > 0) {
				end = mid - 1;
			} else {
				firstIndex = mid;
				break;
			}
		}

		if (firstIndex != -1) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] == a[firstIndex]) {
					firstIndex = i;
					break;
				}
			}
		}
    	
    	return firstIndex;
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    /**
     * Binary Search the index of last key equals the search key, return -1
     * @param <Key> The class of the objects in the array.
     * @param a the array to be searched.
     * @param key the value key to be searched for.
     * @param comparator
     * @return Index of the search key, if not fined return -1.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if(a == null || key == null || comparator == null) {
    		throw new NullPointerException("Data cannot be null");
    	}
    	
    	int start = 0;
    	int end = a.length;
    	int mid = 0;
    	int lastIndex = -1;
    	
		while (start <= end) {

			mid = (start + end) / 2;

			if (mid >= a.length) {
				mid -= 1;
			} else if (mid < 0) {
				mid += 1;
			}

			if (comparator.compare(a[mid], key) < 0) {
				start = mid + 1;
			} else if (comparator.compare(a[mid], key) > 0) {
				end = mid - 1;
			} else {
				lastIndex = mid;
				break;
			}
		}

		if (lastIndex != -1) {
			
			for (int i = a.length - 1; i > 0; i--) {
				
				if (a[i] == a[lastIndex]) {
					lastIndex = i;
					break;
				}
			}
		}

    	return lastIndex;
    }
    
    /**
     * Testing
     * @param args
     */
    public static void main(String[] args) {
    	
    	Integer[] testArray= {
    			1,8,56,46,45,32,94,5,7,6,2,55,62,43,85,69,78,
    	};
    	
    	//Arrays.sort(testArray);
    	System.out.println(BinarySearchDeluxe_QiCao2.firstIndexOf(testArray,94, Collections.reverseOrder()));
    }
}
