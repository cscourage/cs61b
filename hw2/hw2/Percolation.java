package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private WeightedQuickUnionUF sites;
    private int topVirtualSite;
    private int bottomVirtualSite;
    private boolean[][] flags; // true stands for "open", vice verse.
    private int numOpen;  // so it takes constant time to get the number of open site.


    // create N-by-N grid, with all sites initially blocked.
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N <= 0, Illegal!");
        }
        topVirtualSite = N * N;
        bottomVirtualSite = N * N + 1;
        this.N = N;
        numOpen = 0;

        flags = new boolean[N][N];
        sites = new WeightedQuickUnionUF(N * N + 2);
        // the reason why I don't put the two below into the same for loop is that
        // it might spoil the array's spatial locality. But I don't verify it.
        // and if you want to speed up, you can also use loop unrolling.
        for (int i = 0; i < N; i += 1) {
            sites.union(topVirtualSite, locationTo1D(0, i));
        }
        for (int i = 0; i < N; i += 1) {
            sites.union(bottomVirtualSite, locationTo1D(N - 1, i));
        }
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                flags[i][j] = false;
            }
        }
    }

    private int locationTo1D(int x, int y) {
        return x * N + y;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        validRange(row, col);
        if (flags[row][col]) {
            return;
        }
        flags[row][col] = true;
        numOpen += 1;
        connectNeighbor(row, col, row - 1, col);
        connectNeighbor(row, col, row + 1, col);
        connectNeighbor(row, col, row, col - 1);
        connectNeighbor(row, col, row, col + 1);
    }

    private void connectNeighbor(int row, int col, int neighborRow, int neighborCol) {
        if (neighborRow < 0 || neighborRow >= N || neighborCol < 0 || neighborCol >= N) {
            return;
        }
        if (flags[neighborRow][neighborCol]) {
            sites.union(locationTo1D(row, col), locationTo1D(neighborRow, neighborCol));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validRange(row, col);
        return flags[row][col];
    }

    // is the site (row, col) full?
    // the function if not handled appropriately, it will result backwash.
    public boolean isFull(int row, int col) {
        validRange(row, col);
        if (!flags[row][col]) {
            return false;
        }
        return sites.connected(locationTo1D(row, col), topVirtualSite);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return sites.connected(topVirtualSite, bottomVirtualSite);
    }

    private void validRange(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("index out of range.");
        }
    }

    // use for unit testing (not required)
    public static void main(String[] args) {

    }
}
