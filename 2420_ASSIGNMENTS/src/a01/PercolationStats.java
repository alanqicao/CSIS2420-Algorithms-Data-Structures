/**
 * 
 */
package a01;

import edu.princeton.cs.algs4.StdRandom;

/**
 * percolation probability experiments estimation
 * @author Qi Cao
 *
 */
public class PercolationStats {
	
	private Percolation myPerco;
	private double[] experiments;
	private int counterOpenSites;
	
	/**
	 * // perform T independent experiments on an NbyN grid
	 * @param N size of the grid
	 * @param T how many time of experiments
	 */
	public PercolationStats(int N, int T) {
		
		if(N <= 0 || T<=0) {
			throw new IllegalArgumentException("Grid size or experiment count must be greater than 0");
		}
		
		experiments = new double[T];
		
		
		for(int i = 0; i < T; i++ ) {
			
			myPerco = new Percolation(N);
			counterOpenSites = 0;
			
			
			while(!myPerco.percolates()) {
				
				int randomRow = StdRandom.uniform(N);
				int randomColunm = StdRandom.uniform(N);
				
				if(!myPerco.isOpen(randomRow, randomColunm)) {
					myPerco.open(randomRow, randomColunm);
				};
				counterOpenSites++;
			}
			
		}
		
		
		
		
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
