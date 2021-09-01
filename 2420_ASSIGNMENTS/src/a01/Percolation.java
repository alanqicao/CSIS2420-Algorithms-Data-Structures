package a01;

/**
 * Models a perolation sysytem
 * @author Alan
 *
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int N;
	private int[] grid;
	private WeightedQuickUnionUF wUnionFind;
	//private WeightedQuickUnionUF wUnionFoundSupport;

	/**
	 * Create a NbyN grid, with, with all sites blacked.
	 * 
	 * @param N size of the gird
	 */
	public Percolation(int N) {

		if (N <= 0) {

			throw new java.lang.IllegalArgumentException("N must be greater than 0");
		}

		this.N = N;

		// Initialize virtual site
		
		wUnionFind = new WeightedQuickUnionUF((N * N) + 2);
		//try to avoid backwash.
		
		
		//Connect top virtual site to top row sites.
		
		for(int i = 1; i< N + 1; i++) {
			
			wUnionFind.union(i, 0);
			
		}
		
		//Connect bottom virtual site to bottom row sites.
		for(int i = N * N; i > N * N - N; i--) {
			wUnionFind.union(i, (N * N) + 1);
		}
		
		// create grid.
		grid = new int[N * N];

		// Initialize all grid to be blocked.
		for (int i = 0; i < N * N; i++) {
			grid[i] = 0;
		}

		
	}

	/**
	 * open site (row i, column j) if it is not open already.
	 * 
	 * @param i index of the
	 * @param j index of the column
	 */
	public void open(int i, int j) {
		isValidRow(i,j);
		
		
	}

	/**
	 * Determines whether site (row i, column j) open.
	 * 
	 * @param i index of row
	 * @param j index of column
	 * @return True if the site is open
	 */
	public boolean isOpen(int i, int j) {
		isValidRow(i,j);
		return false;// TODO
	}

	/**
	 * Check is site (row i, column j) full.
	 * 
	 * @param i index of row
	 * @param j index of column
	 * @return True if full.
	 */
	public boolean isFull(int i, int j) {
		isValidRow(i,j);
		
		return false;// TODO
	}

	/**
	 * Check does the system percolate.
	 * 
	 * @return true if percolate
	 */
	public boolean percolates() {

		return false;// TODO

	}
	
	private void isValidRow(int i, int j) {
		
		if (i < 0 || i >= N)
			throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (N - 1));
		
	}

}
