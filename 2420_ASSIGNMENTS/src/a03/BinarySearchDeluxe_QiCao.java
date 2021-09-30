package a03;

import java.util.Comparator;

/**
 * 
 * @author Qi Cao
 *
 */
public class BinarySearchDeluxe_QiCao {

    // Return the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	
      	if(a==null||key==null||comparator==null) {
      		
    		throw new NullPointerException("Data cannot be null");
    		
    	}
/*
    	int start = 0;	

    	int last = a.length - 1;
    	
    	while(start <= last) {
    		
    		int mid = a.length / 2;
    		
    		if(comparator.compare(a[mid], key) == 0)
    			return mid;
    		
    		if(comparator.compare(a[mid], key) < 0) 
    			start = mid + 1;
    		else
    			last = mid - 1;		
    		
    	}
    	
    	return -1;	
    */
      	
      int mid = a.length/2;
  	  int start = 0;	
  	  int last = a.length - 1;
  	  
  	  if(comparator.compare(a[mid], key) == 0)
		return mid;
  	  
  	  if(comparator.compare(a[mid], key)<0) {
  		  for(int i = 0; i<mid;i++) {
  			  if()
  		  }
  	  }
      	
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