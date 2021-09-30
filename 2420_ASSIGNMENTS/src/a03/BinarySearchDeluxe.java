package a03;

import java.util.Comparator;

public class BinarySearchDeluxe {

	// Return the index of the first key in a[] that equals the search key, or -1 if no such key.
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

}
