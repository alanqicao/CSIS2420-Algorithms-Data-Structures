package a01;

import edu.princeton.cs.algs4.*;
/**
 * Models a percolation system.
 * 
 * @author Danny
 * @author Chi
 */
public class Percolation_Danny {
	
	//Weighted quick union UF grid to make connections.
	private WeightedQuickUnionUF UFGrid;
	
	//Grid of booleans representing open and closed spots.
	private boolean[] grid;
	
	//Length/width of the grid
	private int n;
	
	//Extra site index representing the starting point of the grid in the WeightedQuickUnionUF.
	private int start;
	
	//Extra site index representing the finishing point of the grid in the WeightedQuickUnionUF.
	private int finish;
	
	
	/**
	 * Generates a Percolation object.
	 * 
	 * @param N Size of the NxN grid.
	 */
	public Percolation_Danny(int N) {
	
		//Initialize n.
		n = N;
		
		//Set indexes for top site and bottom site.
		start = n*n;
		finish = n*n+1;
		
		//Set up weightedquickUF data structure and boolean array
		//to determine if the site is open or closed. 
		UFGrid = new WeightedQuickUnionUF((n*n)+2);
		grid = new boolean[n*n];
	}
	
	/**
	 * Opens site (row i, column j) if it is not open already.
	 * 
	 * @param i The row value of the site.
	 * @param j The column value of the site.
	 */
	public void open(int i, int j){
		//Validate coordinates.
		validate(i,j);
		
		//Get coordinates and open them on boolean grid.
		int coord = twoDToOneD(i, j);
		grid[coord] = true;
		
		//Create array to store each of this site's neighbors.
		int[] neighbors = { (coord - n), (coord + n), (coord - 1), (coord + 1) };
		
		//check to see if neighbors are in bounds and haven't been linked yet
		//If they are in bounds and haven't been linked, perform union operation on them
		for(int k = 0; k < 4; k++) {
			if(neighbors[k] >= 0 && neighbors[k] <= n*n-1 && grid[neighbors[k]]) {
				UFGrid.union(coord, neighbors[k]);
			}
		}
		
		//Link to start if on top row.
		//1d coordinates less than N are the top row
		if(coord < this.n) {
			UFGrid.union(coord,  start);
		}
		
		//Link to bottom if on bottom row.
		//1D coordinates greater than (n^2)- n are on the bottom row.
		if(coord >= (n*n)-n) {
			UFGrid.union(coord, finish);
		}
		
	}
	
	/**
	 * Returns if site (row i, column j) open.
	 * 
	 * @param i The row value of the site.
	 * @param j The column value of the site.
	 * @return A boolean representing whether the site is open or not.
	 */
	public boolean isOpen(int i, int j){
		//Validate coordinates.
		validate(i,j);
		
		//Return the the value of the site from the 1D array.
		return grid[twoDToOneD(i,j)];
	}
	
	/**
	 * Returns whether site (row i, column j) is full or not.
	 * 
	 * @param i The row value of the site.
	 * @param j The column value of the site.
	 * @return A boolean representing if the site is full or not.
	 */
	public boolean isFull(int i, int j){
		//validate coordinates
		validate(i,j);
		
		//Determine if this site is connected to the start.
		return UFGrid.connected(twoDToOneD(i, j), start);
	}
	
	/**
	 * Determines if the grid percolates.
	 * 
	 * @return A boolean representing if the grid percolates or not.
	 * Returns true if the grid percolates, and false if not.
	 */
	public boolean percolates() {
		//Determine if the start site and finish site are connected.
		return UFGrid.connected(start, finish);
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
	 */
	private int twoDToOneD(int i, int j) {
		validate(i, j);
		return n * i + j;
	}
	
	/**
	 * Determines if given coordinates are valid or not.
	 * 
	 * @param i The row value of the site.
	 * @param j The column value of the site.
	 * @throws IndexOutOfBoundsException If i and j are out of bounds.
	 */
	private void validate(int i, int j) throws IndexOutOfBoundsException {
		//see if i and j are outside of the NxN grid.
		if((i < 0 || i >= n) || (j < 0 || j >= n)) {
			throw new IndexOutOfBoundsException("Coordinates (" + i + ", " + j + ")"
					+ " out of bounds");
		}
	}
	
	/**
	 * Main function - Acts as a test client for {@link Percolation}.
	 * 
	 * @param args Size of N for NxN grid.  Default value is 10000.
	 */
	public static void main(String[] args) {
		//Initialize N
		int n = 10000;
		if(args[0] != null)
			n = Integer.parseInt(args[0]);
		
		//Set up grid and open a path from top to bottom.
		Percolation p = new Percolation(n);
		for(int i = 0; i < n; i++)
			p.open(i, 1);
		
		//Determine if system percolates.
		System.out.println(p.percolates());
	}
}
