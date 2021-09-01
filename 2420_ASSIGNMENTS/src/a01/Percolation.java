package a01;
/**
 * Models a perolation sysytem
 * @author Alan
 *
 */

public class Percolation {
	/**
	 * Create a NbyN grid, with, with all sites blacked.
	 * @param N size of the gird
	 */
	
	private int size;
	private int[] grid;
	
		public Percolation(int N){
			
			//TODO
		}
		
		/**
		 * open site (row i, column j) if it is not open already.
		 * @param i index of the 
		 * @param j index of the column
		 */
		public void open(int i, int j){
			
			//TODO
		}
		
		/**
		 * Determines whether site (row i, column j) open.
		 * @param i index of row
		 * @param j index of column
		 * @return True if the site is open
		 */
		public boolean isOpen(int i, int j){
			
			return false;//TODO
		}
		
		/**
		 * Check is site (row i, column j) full.
		 * @param i index of row
		 * @param j index of column
		 * @return True if full.
		 */
		public boolean isFull(int i, int j) {
			
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
