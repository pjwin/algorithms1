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
        if (((columns - dimension) <= val) && (val < columns)) {
            bottomArray[val] = true;
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
        if (isOpen(row, col)) {
            if (topArray[xyTo1D(row, col)]) {
                if (bottomArray[xyTo1D(row, col)] && topArray[xyTo1D(row, col)]) {
                    percolates = true;
                }
                return true;
            }
            if (topArray[parentArray.find(xyTo1D(row, col))]) {
                topArray[xyTo1D(row, col)] = true;
                if (bottomArray[xyTo1D(row, col)] && topArray[xyTo1D(row, col)]) {
                    percolates = true;
                }
                return true;
            }
        }

        return false;
    }

    public boolean percolates() {
        return percolates;
    }

    private void unionNeighbor(int val, int neighbor) {
        if (!(parentArray.connected(val, neighbor))) {
            parentArray.union(parentArray.find(val), parentArray.find(neighbor));
        }
        
        if (topArray[val] || topArray[neighbor] || topArray[parentArray.find(val)]
                || topArray[parentArray.find(neighbor)]) {
            topArray[val] = true;
            topArray[neighbor] = true;
            topArray[parentArray.find(val)] = true;
            topArray[parentArray.find(neighbor)] = true;
        }
        if (bottomArray[val] || bottomArray[neighbor] || bottomArray[parentArray.find(val)]
                || bottomArray[parentArray.find(neighbor)]) {
            bottomArray[val] = true;
            bottomArray[neighbor] = true;
            bottomArray[parentArray.find(val)] = true;
            bottomArray[parentArray.find(neighbor)] = true;
        }
        
        if (bottomArray[val] && topArray[val]){
            percolates = true;
        }
        
        //is this val connected to top/bottom?
        //is the parent connected to top/bottom?
        //is the neighbor connected to top/bottom?
        //is the neighbor's parent connected to top/bottom?
        //is it connected to top and bottom?
        
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
