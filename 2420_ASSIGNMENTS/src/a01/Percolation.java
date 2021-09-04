package a01;

/**
 * Models a perolation sysytem
 * @author Qi Cao
 * @author Danny
 *
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int N;
	private boolean[][] grid;
	private WeightedQuickUnionUF myUnionFind;
	private WeightedQuickUnionUF myBackwash;
	private int topPoint;
	private int endPoint;
	


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
		

		topPoint =(N*N);
		endPoint=(N*N)+1;

		
		// Initialize virtual site
		

		myUnionFind = new WeightedQuickUnionUF((N * N) + 2);
		//try to avoid backwash.
		myBackwash = new WeightedQuickUnionUF((N * N )+1);

		
		//Connect top virtual site to top row sites.
	for(int i=0; i<N;i++) {
		myUnionFind.union(i, topPoint);
		myBackwash.union(i, topPoint);
		myUnionFind.union(topPoint-i-1, endPoint);
	}
		
		// create grid.
		grid = new boolean[N][N];

		// Initialize all grid open
		
		for(int gridRow = 0; gridRow<N;gridRow++) {
			for(int gridColumn = 0; gridColumn < N; gridColumn++) {
				grid[gridRow][gridColumn] =false;
			}
		}
		

	}
/**
 * Converted i and j to One Dimension number
 * @param x index of  row
 * @param y index of  column
 * @return number represent the one dimension x and y.
 */
	private int xyToOneDimension(int x, int y) {
		int convertedOneDimension;
		convertedOneDimension = (N*x)+y;
		return convertedOneDimension;

	}
	
	/**
	 * Check if given row and column are validate, return exception if they are.
	 * @param i index of row
	 * @param j index of column
	 */
	private void checkValidate(int i, int j) {
		if (i < 0 || i >= N)
			throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (N - 1));
		
		if (j < 0 || j >= N)
			throw new IndexOutOfBoundsException("colum index " + j + " must be between 0 and " + (N - 1));

	}
	
	/**
	 * open site (row i, column j) if it is not open already.
	 * 
	 * @param i index of the
	 * @param j index of the column
	 */
	public void open(int i, int j) {

		//check validate of the data.
		checkValidate(i, j);
		//Open the box inside grid.
		grid[i][j] = true;
		
		
		//Check 4 direction if they are open, if yes connect them.
		//Check if it is at top row, if yes 
		
		//check above
		if(i==0) {
			myUnionFind.union(xyToOneDimension(i,j), topPoint);
			myBackwash.union(xyToOneDimension(i,j), topPoint);
		}else if(isOpen(i-1,j)) {
				myUnionFind.union(xyToOneDimension(i-1,j),xyToOneDimension(i,j));
				myBackwash.union(xyToOneDimension(i-1,j),xyToOneDimension(i,j));
			
		}
		
		//check below
		if(i==(N-1)) {
			myUnionFind.union(xyToOneDimension(i, j),endPoint);
		}else if(isOpen(i+1,j)) {
			myUnionFind.union(xyToOneDimension(i+1,j),xyToOneDimension(i,j));
			myBackwash.union(xyToOneDimension(i+1,j),xyToOneDimension(i,j));
		}
		
		
		//check left
		
		if(j-1 >= 0 && grid[i][j-1]) {
			myUnionFind.union(xyToOneDimension(i,j-1),xyToOneDimension(i,j));
			myBackwash.union(xyToOneDimension(i,j-1),xyToOneDimension(i,j));
		}
		
		//check right
		if(j+1 < N && grid[i][j+1]) {
			myUnionFind.union(xyToOneDimension(i,j+1),xyToOneDimension(i,j));
			myBackwash.union(xyToOneDimension(i,j+1),xyToOneDimension(i,j));
		}

		
		
	}

	/**
	 * Determines whether site (row i, column j) open.
	 * 
	 * @param i index of row
	 * @param j index of column
	 * @return True if the site is open
	 */
	public boolean isOpen(int i, int j) {

		checkValidate(i,j);
		
		return grid[i][j];

	}

	/**
	 * Check is site (row i, column j) full.
	 * 
	 * @param i index of row
	 * @param j index of column
	 * @return True if full.
	 */
	public boolean isFull(int i, int j) {

		checkValidate(i,j);
		
		if(!isOpen(i,j)) {
			return false;
		}
		
		
		return myBackwash.connected(topPoint,xyToOneDimension(i,j));

	}

	/**
	 * Check does the system percolate.
	 * 
	 * @return true if percolate
	 */
	public boolean percolates() {
		

		return myUnionFind.connected(topPoint, endPoint);

	}
	


}
