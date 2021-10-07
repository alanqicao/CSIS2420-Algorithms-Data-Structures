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
    	int end = a.length;
    	int mid = 0;
    	int firstIndex = -1;
    	
    	while(start <= end) {
    		mid = (start + end)/2;
    		if(mid >= a.length) {
    			mid -= 1;
    		}else if(mid < 0) {
    			mid += 1;
    		}
    		if(comparator.compare(a[mid], key) < 0) {
    			start = mid + 1;
    		}else if(comparator.compare(a[mid], key) > 0) {
    			end = mid - 1;
    		}else {
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
    	int end = a.length;
    	int mid = 0;
    	int lastIndex = -1;
    	
    	while(start <= end) {
    		mid = (start + end)/2;
    		if(mid >= a.length) {
    			mid -= 1;
    		}else if(mid < 0) {
    			mid += 1;
    		}
    		if(comparator.compare(a[mid], key) < 0) {
    			start = mid + 1;
    		}else if(comparator.compare(a[mid], key) > 0) {
    			end = mid - 1;
    		}else {
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

}
