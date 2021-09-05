/**
 * 
 */
package a01;

/**
 * percolation probability experiments estimation
 * @author Qi Cao
 *
 */
public class PercolationStats {
	
	private Percolation myPerco;
	private double[] experiments;
	
	/**
	 * // perform T independent experiments on an NbyN grid
	 * @param N size of the grid
	 * @param T how many time of experiments
	 */
	public PercolationStats(int N, int T) {
		
		if(N <= 0 || T<=0) {
			throw new IllegalArgumentException("Grid size or experiment count must be greater than 0");
		}
		
		
		myPerco = new Percolation(N);
		
		
		
	}
	
	
	
	/**
	 *  // sample mean of percolation threshold
	 * @return
	 */
	public double mean() {
		return -1;
	}
	
	
	/**
	 *  // sample standard deviation of percolation threshold
	 * @return
	 */
	public double stddev() {
		return -1;
	}
	
	
	/**
	 *  // low endpoint of 95% confidence interval
	 * @return
	 */
	public double confidenceLow() {
		return -1;
	}
	
	/**
	 * // high endpoint of 95% confidence interval
	 * @return
	 */
	public double confidenceHigh() {
		return -1;
	}
}
