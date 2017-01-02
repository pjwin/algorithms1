import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private double[] values;
    private int trials;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new java.lang.IllegalArgumentException();
        this.values = new double[trials];
        this.trials = trials;
        double sites = n * n;

        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!(perc.percolates())) {
                // FIXME generate a unique pair not chosen yet.
                perc.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
            }
            this.values[i] = ((double) perc.numberOfOpenSites() / sites);
        }
    }

    public double mean() {
        return StdStats.mean(values);
    }

    public double stddev() {
        return StdStats.stddev(values);
    }

    public double confidenceLo() {
        return StdStats.mean(values) - (1.96 / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return StdStats.mean(values) + (1.96 / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(200, 100);
        System.out.println("mean: " + ps.mean());
        System.out.println("stddev: " + ps.stddev());
        System.out.println("95% confidence interval: " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }
}
