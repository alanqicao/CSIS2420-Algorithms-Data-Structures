package a01;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PercolationTest {
	
	private static final int GRID_SIZE = 9;
	private Percolation percolation;
	
	@BeforeEach
	    public void setUp() {
	        percolation = new Percolation(GRID_SIZE);
	    }



	@Test
	void open_shouldNotOpen_returnFalse() {
		assertFalse(percolation.isOpen(1, 1));
	}

	@Test
	void testIsOpen() {
		fail("Not yet implemented");
	}

	@Test
	void testIsFull() {
		fail("Not yet implemented");
	}

	@Test
	void testPercolates() {
		fail("Not yet implemented");
	}

}
