package a01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Percolation probability experiments estimation.
 * 
 * @author Qi Cao
 * @author Danny Dwyer
 */
public class PercolationStats {
	
	//Array of doubles to contain the results of each simulation.
	private double[] experiments;

	/**
	 * Perform T independent experiments on an NxN grid.
	 * 
	 * @param N size of the grid
	 * @param T how many time of experiments run
	 * @throws IllegalArgumentException If N is less than or equal to zero.
	 * @throws IllegalArgumentException If T is less than or equal to zero.
	 */
	public PercolationStats(int N, int T) throws IllegalArgumentException{
		
		//Percolation object used to run simulation.
		Percolation myPerco;
		
		//Counter to store the number of open sites
		int counterOpenSites;

		//Catch bad input
		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Grid size or experiment count must be greater than 0");
		}

		//Set the number of experiments run to T
		experiments = new double[T];

		//Run   the experiment T times
		for (int i = 0; i < T; i++) {

			//Initialize new experiment
			myPerco = new Percolation(N);
			counterOpenSites = 0;

			/*
			 * If percolation grid does not percolate, find a random row and column,
			 * test to see if it is open, and if it isn't open, open that site, and
			 * repeat this process until the grid percolates.
			 */
			while (!myPerco.percolates()) {

				int randomRow = StdRandom.uniform(N);
				int randomColunm = StdRandom.uniform(N);

				if (!myPerco.isOpen(randomRow, randomColunm)) {
					myPerco.open(randomRow, randomColunm);
					counterOpenSites++;
				}
			}
			
			//Store experiment result in array
			experiments[i]= counterOpenSites/Math.pow(N, 2);
		}
	}

	/**
	 * Returns a sample mean of percolation threshold.
	 * 
	 * @return Double representing the mean of the experiments.
	 */
	public double mean() {
		return StdStats.mean(experiments);
	}

	/**
	 * Returns a sample standard deviation of percolation threshold.
	 * 
	 * @return Double representing the standard deviation in these experiments.
	 */
	public double stddev() {
		return StdStats.stddev(experiments);
	}

	/**
	 * Returns a low end-point of 95% confidence interval.
	 * Uses formula: Mean - (1.96 * stddev)/sqrt(total experiments).
	 * 
	 * @return Low end point of 95% confidence interval.
	 */
	public double confidenceLow() {
		return mean() - (1.96 * stddev() / Math.sqrt(experiments.length));
	}

	/**
	 * Returns a high end-point of 95% confidence interval.
	 * Uses formula: Mean + (1.96 * sttdev)/sqrt(total experiments).
	 * 
	 * @return High end point of 95% confidence interval.
	 */
	public double confidenceHigh() {
		return mean() + (1.96 * stddev() / Math.sqrt(experiments.length));
	}

	//Main function to act as a test client for developers.
	public static void main(String[] args) {

		printOut(200, 100);
		printOut(200, 100);
		printOut(2, 1000);

	}

	//Private helper function to assist in formatting main() output.
	private static void printOut(int n, int t) {
		PercolationStats estimation = new PercolationStats(n, t);
		System.out.println("Example values after creating PercolationStats(" + n + "," + t + ")");
		System.out.println("mean()             =" + estimation.mean());
		System.out.println("stddev()           =" + estimation.stddev());
		System.out.println("confidenceLow()    =" + estimation.confidenceLow());
		System.out.println("confidenceHigh()   =" + estimation.confidenceHigh());
		System.out.println();
	}
}