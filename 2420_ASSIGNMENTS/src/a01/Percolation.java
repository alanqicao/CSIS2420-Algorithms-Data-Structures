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
	
	/**
	 * Create a NbyN grid, with, with all sites blacked.
	 * @param N size of the gird
	 */
		public Percolation(int N){
			
			if(N<=0) {
				
				throw new java.lang.IllegalArgumentException("N must be greater than 0");
			}
			
			this.N = N;
			//TODO
		}
		
		/**
		 * open site (row i, column j) if it is not open already.
		 * @param i index of the 
		 * @param j index of the column
		 */
		public void open(int i, int j){
			if (i < 0 || i >= N) throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (N-1));
			//TODO
		}
		
		/**
		 * Determines whether site (row i, column j) open.
		 * @param i index of row
		 * @param j index of column
		 * @return True if the site is open
		 */
		public boolean isOpen(int i, int j){
			if (i < 0 || i >= N) throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (N-1));
			return false;//TODO
		}
		
		/**
		 * Check is site (row i, column j) full.
		 * @param i index of row
		 * @param j index of column
		 * @return True if full.
		 */
		public boolean isFull(int i, int j) {
			if (i < 0 || i >= N) throw new IndexOutOfBoundsException("row index " + i + " must be between 0 and " + (N-1));
			return false;//TODO
		}
		
		/**
		 * Check does the system percolate.
		 * @return true if percolate
		 */
		public boolean percolates(){
			
			return false;//TODO
			
		}
	
	
}
