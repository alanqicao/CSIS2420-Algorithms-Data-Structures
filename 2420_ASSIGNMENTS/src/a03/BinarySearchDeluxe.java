package a03;

import java.util.Comparator;

/**
 * 
 * @author Qi Cao
 *
 */
public class BinarySearchDeluxe {

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if(a == null || key == null || comparator == null) {
    		throw new NullPointerException("Data can not be null");
    	}
    	
    	int size = a.length;
    	
    	for(int i = 0; i< size; i++) {
    		
    		if(a[i]==key) {
    			
    			return i;
    		}
    	}
    	
		return -1;
    	
    }

    // Return the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
    	if(a==null||key==null||comparator==null) {
    		throw new NullPointerException("Data can not be null");
    	}
    	
	int size = a.length;
    	
    	for(int i = size; i>0; i--) {
    		
    		if(a[i]==key) {
    			
    			return i;
    		}
    	}
    	
		return -1;
		
    	
    }
}