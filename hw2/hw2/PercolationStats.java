package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int T;
    private double[] fractions;

    // perform T independent experiments on an N-by-N grid.
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("argument invalid!");
        }
        this.T = T;
        fractions = new double[T];
        for (int i = 0; i < T; i += 1) {
            Percolation percolation = pf.make(N);
            while (!percolation.percolates()) {
                int row, col;
                do {
                    row = StdRandom.uniform(N);
                    col = StdRandom.uniform(N);
                } while (percolation.isOpen(row, col));
                percolation.open(row, col);
            }
            fractions[i] = (double) percolation.numberOfOpenSites() / (N * N);
        }
    }

    // sample mean of percolation threshold.
    public double mean() {
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold.
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
