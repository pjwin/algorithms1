import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int openCount = 0;

	public Percolation(int n) {
		// create n-by-n grid, with all sites blocked
	}

	public void open(int row, int col) {
		// open site (row, col) if it is not open already
		openCount++;
	}

	public boolean isOpen(int row, int col) {
		// is site (row, col) open?
		return false;
	}

	public boolean isFull(int row, int col) {
		// is site (row, col) full?
		return false;
	}

	public int numberOfOpenSites() {
		return openCount;
	}

	public boolean percolates() {
		// does the system percolate?
		return false;
	}

	private int xyTo1D(int row, int col) {
		return 0;
	}
	
	public static void main(String[] args) {
		// test client (optional)
		int n = 50;
		Percolation perc = new Percolation(n);
		System.out.println(perc.numberOfOpenSites());
	}
}
