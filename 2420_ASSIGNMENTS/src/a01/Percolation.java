package a01;

/**
 * Models a percolation system.
 * 
 * @author Qi Cao
 * @author Danny
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	//Length/width of the grid
	private int N;
	
	//Grid of booleans representing open and closed spots.
	private boolean[][] grid;
	
	//Weighted quick union UF grid to make connections.

	private WeightedQuickUnionUF myUnionFind;
	
	//Weighted quick union UF grid to account for backwash.
	private WeightedQuickUnionUF myBackwash;
	
	//Index of start node
	private final int topPoint;
	
	//Index of end node
	private final int endPoint;

	/**
	 * Create a NbyN grid, with, with all sites blacked.
	 * 
	 * @param N size of the gird
	 */
	public Percolation(int N) {

		//set fields
		this.N = N;
		topPoint =(N*N);
		endPoint=(N*N)+1;
		
		//Initialize quickunion to see if things connect
		myUnionFind = new WeightedQuickUnionUF((N * N) + 2);
		
		//try to avoid backwash.
		myBackwash = new WeightedQuickUnionUF((N * N )+1);
		
		//create grid of booleans to see if filled or not.
		grid = new boolean[N][N];
	}
	
	/**
	 * open site (row i, column j) if it is not open already.
	 * 
	 * @param i index of the
	 * @param j index of the column
	 * @author Qi Cao
	 */
	public void open(int i, int j) {

		//check validate of the data.
		validate(i, j);
		//Open the box inside grid.
		grid[i][j] = true;
		
		
		//Check 4 direction if they are open, if yes connect them.
		
		//check above
		if(i==0) {
			myUnionFind.union(twoDToOneD(i,j), topPoint);
			myBackwash.union(twoDToOneD(i,j), topPoint);
		}else if(isOpen(i-1,j)) {
				myUnionFind.union(twoDToOneD(i-1,j),twoDToOneD(i,j));
				myBackwash.union(twoDToOneD(i-1,j),twoDToOneD(i,j));
		}
		
		//check below
		if(i==(N-1)) {
			myUnionFind.union(twoDToOneD(i, j),endPoint);
		}else if(isOpen(i+1,j)) {
			myUnionFind.union(twoDToOneD(i+1,j),twoDToOneD(i,j));
			myBackwash.union(twoDToOneD(i+1,j),twoDToOneD(i,j));
		}
		
		
		//check left
		if(j-1 >= 0 && grid[i][j-1]) {
			myUnionFind.union(twoDToOneD(i,j-1),twoDToOneD(i,j));
			myBackwash.union(twoDToOneD(i,j-1),twoDToOneD(i,j));
		}
		
		//check right
		if(j+1 < N && grid[i][j+1]) {
			myUnionFind.union(twoDToOneD(i,j+1),twoDToOneD(i,j));
			myBackwash.union(twoDToOneD(i,j+1),twoDToOneD(i,j));
		}		
	}

	/**
	 * Determines whether site (row i, column j) open.
	 * 
	 * @param i index of row
	 * @param j index of column
	 * @return True if the site is open, false otherwise.
	 * @author Qi Cao
	 */
	public boolean isOpen(int i, int j) {
		//validate coordinates
		validate(i,j);
		
		//return boolean from grid, true if open.
		return grid[i][j];
	}

	/**
	 * Check is site (row i, column j) full.
	 * 
	 * @param i Index of row.
	 * @param j Index of column.
	 * @return True if full, false otherwise.
	 * @author Qi Cao
	 */
	public boolean isFull(int i, int j) {
		//validate coordinates
		validate(i,j);

		//return weather the top and this point is connected.
		return myBackwash.connected(topPoint,twoDToOneD(i,j));
	}

	/**
	 * Check does the system percolates.
	 * 
	 * @return True if percolates, false otherwise.
	 * @author Qi Cao
	 * @author Danny
	 */
	public boolean percolates() {
		//determine if top and bottom are connected.
		return myUnionFind.connected(topPoint, endPoint);
	}
	
	/**
	 * Private method that converts 2d coordinates into 1d coordinates
	 * Given we are working with an array with size NxN, the formula 
	 * we're using is n * i + j, since n*i gets us the row values and
	 * then adding j gets us to what column we're supposed to be on.
	 * 
	 * @param i The row value of the site.
	 * @param j The column value of the site.
	 * @return An integer representing (i, j) on a 1D plane.
	 * @author Danny
	 */
	private int twoDToOneD(int i, int j) {
		validate(i, j);
		return N * i + j;
	}
	
	/**
	 * Determines if given coordinates are valid or not.
	 * 
	 * @param i The row value of the site.
	 * @param j The column value of the site.
	 * @throws IndexOutOfBoundsException If i and j are out of bounds.
	 * @author Danny
	 */
	private void validate(int i, int j) throws IndexOutOfBoundsException {
		//see if i and j are outside of the NxN grid.
		if((i < 0 || i >= N) || (j < 0 || j >= N)) {
			throw new IndexOutOfBoundsException("Coordinates (" + i + ", " + j + ")"
					+ " out of bounds");
		}
	}
}
