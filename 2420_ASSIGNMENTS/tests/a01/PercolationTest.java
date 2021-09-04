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
	void open_shoulOpen_returnTrue() {
		percolation.open(1,1);
		assertTrue(percolation.isOpen(1, 1));
	}

	@Test
	void percolates_shoulPercolates_returnTrue() {
			percolation.open(0, 2);
			percolation.open(1, 2);
	        percolation.open(2, 2);
	        percolation.open(3, 2);
	        percolation.open(4, 2);
	        percolation.open(5, 2);
	        percolation.open(6, 2);
	        percolation.open(7, 2);
	        percolation.open(8, 2);
	        assertTrue(percolation.percolates());
	}
	
	@Test
	void percolates_shoulNotPercolates_returnFalse() {
			percolation.open(0, 0);
			percolation.open(0, 1);
	        percolation.open(0, 2);
	        percolation.open(0, 3);
	        percolation.open(0, 4);
	        percolation.open(0, 5);
	        percolation.open(0, 6);
	        percolation.open(0, 7);
	        percolation.open(0, 8);
	        assertFalse(percolation.percolates());
	}
	
	
	@Test
	void isFull_shoulBeFull_returnTrue() {
		percolation.open(0, 0);
		percolation.open(0, 1);
		assertTrue(percolation.isFull(0, 1));
	}
	
	
	@Test
	void isFull_shoulNotBeFull_returnFlase() {
		percolation.open(2, 1);
		
		assertFalse(percolation.isFull(2, 1));
	}
	

	@Test
	void isOpen_shoulNotOpen_returnFalse() {
		assertFalse(percolation.isOpen(8, 8));
	}
	
	
	





}
