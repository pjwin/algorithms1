import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int openCount = 0;
    private WeightedQuickUnionUF parentArray;
    private boolean[] stateArray;
    private boolean[] topArray;
    private boolean[] bottomArray;
    private int dimension;
    private int columns;
    private boolean percolates = false;

    public Percolation(int n) {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException();
        dimension = n;
        columns = dimension * dimension;
        parentArray = new WeightedQuickUnionUF(columns);
        stateArray = new boolean[columns];
        topArray = new boolean[columns];
        bottomArray = new boolean[columns];
    }

    public void open(int row, int col) {
        validateRowCol(row, col);
        int arrVal = xyTo1D(row, col);
        if (!(stateArray[arrVal])) {
            stateArray[arrVal] = true;
            openCount++;
            findNeighbors(arrVal);
        }
    }

    private void findNeighbors(int val) {
        // connect to "top"
        if (val < dimension) {
            topArray[val] = true;
        }
        // connect to "bottom"
        if (((columns - dimension) < val) && (val < columns)) {
            bottomArray[parentArray.find(val)] = true;
        }
    
        int neighbor;
        neighbor = val - dimension; // above
        if (neighbor >= 0 && stateArray[neighbor])
            unionNeighbor(val, neighbor);
    
        neighbor = val + dimension; // below
        if (neighbor < columns && stateArray[neighbor])
            unionNeighbor(val, neighbor);
    
        neighbor = val - 1; // left
        if ((val % dimension > 0) && (neighbor >= 0) && stateArray[neighbor])
            unionNeighbor(val, neighbor);
    
        neighbor = val + 1; // right
        if ((val % dimension < (dimension - 1)) && (neighbor < columns) && stateArray[neighbor])
            unionNeighbor(val, neighbor);
    }

    public boolean isFull(int row, int col) {
        validateRowCol(row, col);
        if (isOpen(row, col) && topArray[xyTo1D(row, col)]) {
            return true;
        }
        return false;
    }

    public boolean percolates() {
        return percolates;
    }

    private void unionNeighbor(int val, int neighbor) {
        if (topArray[neighbor]) {
            topArray[val] = true;
        }
        if (topArray[val] == true && topArray[neighbor] == false) {
            topArray[neighbor] = true;
        }
        if (!(parentArray.connected(val, neighbor))) {
            parentArray.union(parentArray.find(val), parentArray.find(neighbor));
        }
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    public boolean isOpen(int row, int col) {
        validateRowCol(row, col);
        return stateArray[xyTo1D(row, col)];
    }

    private int xyTo1D(int row, int col) {
        return (dimension * (row - 1)) + col - 1;
    }

    private void validateRowCol(int row, int col) {
        if (row <= 0 || row > dimension) {
            throw new java.lang.IndexOutOfBoundsException("row index out of bounds:" + row);
        }
        if (col <= 0 || col > dimension) {
            throw new java.lang.IndexOutOfBoundsException("col index out of bounds:" + col);
        }
    }
}
