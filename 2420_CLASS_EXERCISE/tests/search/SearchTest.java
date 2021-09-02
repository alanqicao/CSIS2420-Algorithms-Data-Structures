package search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {
	// = = = linear for int[] = = =
	private int[] numbers = {60,10,12,5,12,17,29,13,40};
	

	@Test
	void linear_firstElement_returnIndex0() {
		
		int expected = 0;
		int actual = Search.liner(numbers, 60);
		assertEquals(expected,actual);
		
	}
	
	
	@Test
	void linear_lastElement_returnLastIndex() {	
		assertEquals(8,Search.liner(numbers, 40));
	}
	
	
	@Test
	void linear_elementNotInArray_returnMinusOne() {
		assertEquals(-1,Search.liner(numbers, 99));
	}
	
	@Test
	void linear_duplicateElement() {
		assertEquals(2,Search.liner(numbers, 12));
	}
	
	
	@Test
	void linear_emptyArray_returnMinusOne() {		
		assertEquals(-1,Search.liner(new int[0], 50));
	}
	
	
	@Test
	void linear_nullArray_returnMinusOne() {		
		 assertThrows(NullPointerException.class, () -> {
		       Search.liner(null, 50);
		    });
	}
	
	
	// = = = linear for type T[] = = =
	
	
	private Double[] arrayDouble = {60.5,10.5,12.5,5.5,12.5,17.5,29.5,13.5,40.5};
	private String[] arrayString = {"cat","dog","ant","bet"};
	

	@Test
	void linearT_firstElement_returnIndex0() {
		
		
		assertEquals(0,Search.liner(arrayString, "cat"));
		
	}
	
	
	@Test
	void linearT_lastElement_returnLastIndex() {	
		assertEquals(8,Search.liner(arrayDouble, 40.5));
	}

	@Test
	void linearT_emptyArray_returnMinusOne() {		
		assertEquals(-1,Search.liner(new int[0], 50));
	}
	
	@Test
	void linearT_duplicateElement() {
		assertEquals(2,Search.liner(arrayDouble, 12.5));
	}
	
	
	@Test
	void linearT_nullArray_returnMinusOne() {		
		 assertThrows(NullPointerException.class, () -> {
		       Search.liner(null, 50);
		    });
	}
	

	@Test
	void linearT_elementNotInArray_returnMinusOne() {
		assertEquals(-1,Search.liner(arrayString,"zebra"));
	}
	
}
