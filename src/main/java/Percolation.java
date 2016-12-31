import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int openCount = 0;
	private WeightedQuickUnionUF parentArray;
	private boolean[] stateArray;
	private int dimension;
	private int columns;
	
	public int union = 0;

	public Percolation(int n) {
		if (n <= 0)	throw new java.lang.IllegalArgumentException();
		dimension = n;
		columns = dimension * dimension;
		parentArray = new WeightedQuickUnionUF(columns + 2);
		stateArray = new boolean[columns];
	}

	public void open(int row, int col) {
		validateRowCol(row, col);
		int arrVal = xyTo1D(row, col);
		stateArray[arrVal] = true;
		openCount++;
		findNeighbors(arrVal);
	}

	public boolean isOpen(int row, int col) {
		validateRowCol(row, col);
		return stateArray[xyTo1D(row, col)];
	}

	public boolean isFull(int row, int col) {
		validateRowCol(row, col);
		if (isOpen(row, col) && parentArray.connected(xyTo1D(row, col), columns)) {
			return true;
		}
		return false;
	}

	public int numberOfOpenSites() {
		return openCount;
	}

	public boolean percolates() {
		if (parentArray.connected(columns, columns + 1)) {
			return true;
		}
		return false;
	}

	private int xyTo1D(int row, int col) {
		return (dimension * (row - 1)) + col - 1;
	}

	private void findNeighbors(int val) {
		int neighbor;
		//if on the top row, connect to "top" element n*n
		if (val < dimension) parentArray.union(parentArray.find(val), parentArray.find(columns));
		//if on the bottom row, connect to "bottom" element n*n + 1
		if (((columns - dimension) < val) && (val < columns)) parentArray.union(parentArray.find(val), parentArray.find(columns + 1));
		
		neighbor = val - dimension; // above
		if (neighbor >= 0 && stateArray[neighbor]) {
			unionNeighbor(val, neighbor);
		}
		neighbor = val + dimension; // below
		if (neighbor < columns && stateArray[neighbor]) {
			unionNeighbor(val, neighbor);
		}
		neighbor = val - 1; // left
		if ((val % dimension > 0) && (neighbor >= 0) && stateArray[neighbor]) {
			unionNeighbor(val, neighbor);
		}
		neighbor = val + 1; // right
		if ((val % dimension < (dimension - 1)) && (neighbor < columns) && stateArray[neighbor]) {
			unionNeighbor(val, neighbor);
		}
	}

	private void unionNeighbor(int val, int neighbor) {
		if (!(parentArray.connected(val, neighbor))) {
			parentArray.union(parentArray.find(val), parentArray.find(neighbor));		
		}
	}
	
	private void validateRowCol(int row, int col) {
		if (row <= 0 || row > dimension) {
			throw new java.lang.IndexOutOfBoundsException("row index out of bounds");
		}
		if (col <= 0 || col > dimension) {
			throw new java.lang.IndexOutOfBoundsException("col index out of bounds");
		}
	}
}
