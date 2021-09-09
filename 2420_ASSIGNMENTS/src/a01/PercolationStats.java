/**
 * 
 */
package a01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * percolation probability experiments estimation
 * 
 * @author Qi Cao
 *
 */
public class PercolationStats {

	private Percolation myPerco;
	private double[] experiments;
	private int counterOpenSites;

	/**
	 * // perform T independent experiments on an NbyN grid
	 * 
	 * @param N size of the grid
	 * @param T how many time of experiments
	 */
	public PercolationStats(int N, int T) {

		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Grid size or experiment count must be greater than 0");
		}

		experiments = new double[T];

		for (int i = 0; i < T; i++) {

			myPerco = new Percolation(N);
			counterOpenSites = 0;

			while (!myPerco.percolates()) {

				int randomRow = StdRandom.uniform(N);
				int randomColunm = StdRandom.uniform(N);

				if (!myPerco.isOpen(randomRow, randomColunm)) {
					myPerco.open(randomRow, randomColunm);
					counterOpenSites++;
				}
				

			}

			experiments[i] = counterOpenSites / (double) (N * N);
			// experiments[i]= counterOpenSites/Math.pow(N, 2);

		}

	}

	/**
	 * // sample mean of percolation threshold
	 * 
	 * @return
	 */
	public double mean() {
		return StdStats.mean(experiments);
	}

	/**
	 * // sample standard deviation of percolation threshold
	 * 
	 * @return
	 */
	public double stddev() {
		return StdStats.stddev(experiments);
	}

	/**
	 * // low endpoint of 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceLow() {

		return mean() - (1.96 * stddev() / Math.sqrt(experiments.length));
	}

	/**
	 * // high endpoint of 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceHigh() {

		return mean() + (1.96 * stddev() / Math.sqrt(experiments.length));
	}

	public static void main(String[] args) {

		printOut(200, 100);
		printOut(200, 100);
		printOut(2, 1000);

	}

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
