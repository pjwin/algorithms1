import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int openCount = 0;
	private WeightedQuickUnionUF parentArray;
	private boolean[] stateArray;
	private int dimension;

	public Percolation(int n) {
		this.dimension = n;
		int columns = n * n;
		parentArray = new WeightedQuickUnionUF(columns);
		stateArray = new boolean[columns];
	}

	public void open(int row, int col) {
		int arrVal = xyTo1D(row, col);
		stateArray[arrVal] = true;
		openCount++;
		
		// connect to other open neighbors.
		// recursively?
	}
	
	private int[] getOpenNeighbors(int val) {
		
		int[] neighbors = new int[4];
		//above
		if (val - dimension >= 0) neighbors[0] = val - dimension;
		//below
		if (val + dimension < dimension*dimension) neighbors[1] = val + dimension;
		//left
		
		//right
		
		int left;
		int right;
		int below;
		
		return null;
	}
	
	public boolean isOpen(int row, int col) {
		return stateArray[xyTo1D(row, col)];
	}

	public boolean isFull(int row, int col) {
		// is site (row, col) full?
		// isOpen(row, col)
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
		return (dimension * (row - 1)) + col - 1;
	}

	public boolean[] getStateArray() {
		return stateArray;
	}
}
