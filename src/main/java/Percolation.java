import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int openCount = 0;
	//FIXME make private
	public WeightedQuickUnionUF parentArray;
	private boolean[] stateArray;
	private int dimension;
	private int columns;

	public Percolation(int n) {
		if (n <= 0) throw new java.lang.IllegalArgumentException();
		this.dimension = n;
		this.columns = dimension * dimension;
		parentArray = new WeightedQuickUnionUF(columns);
		stateArray = new boolean[columns];
	}
	
	public void open(int row, int col) {
		validateRowCol(row, col);
		int arrVal = xyTo1D(row, col);
		stateArray[arrVal] = true;
		openCount++;
		unionNeighbors(arrVal);
	}
	
	public boolean isOpen(int row, int col) {
		validateRowCol(row, col);
		return stateArray[xyTo1D(row, col)];
	}
	
	public boolean isFull(int row, int col) {
		validateRowCol(row, col);
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
	
	private void unionNeighbors(int val) {
		if (val - dimension >= 0 && stateArray[val - dimension]) { //above
			parentArray.union(val, val - dimension);
		} 
		if (val + dimension < columns && stateArray[val + dimension]) { //below
			parentArray.union(val, val + dimension);
		}
		if (val % dimension > 0 && stateArray[val - 1]) { //left
			parentArray.union(val, val - 1);
		}
		if (val % dimension < 4 && stateArray[val + 1]) { //right
			parentArray.union(val, val + 1);
		}
	}
	
	private void validateRowCol(int row, int col){
		if (row <= 0 || row > dimension || col <= 0 || col > dimension){
			throw new java.lang.IndexOutOfBoundsException();
		}
	}
}
