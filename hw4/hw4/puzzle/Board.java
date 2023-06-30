package hw4.puzzle;

/** Your implementation should support all Board methods in time proportional
 *  to N^2 (or faster) in the worst case. */

public class Board implements  WorldState {
    /** Constructs a board from an N-by-N array of tiles where tiles[i][j]
     *  = tile at row i, column j. */
    public Board(int[][] tiles) {
        //TODO
    }

    /** Returns value of tile at row i, column j (or 0 if blank). */
    public int tileAt(int i, int j) {
        //TODO
        //Should throw exceptions unless both i and j are between 0 and N − 1 for corner cases.
        return 0;
    }

    /** Returns the board size N. */
    public int size() {
        //TODO
        return 0;
    }

    /** Returns the neighbors of the current board. */
    @Override
    public Iterable<WorldState> neighbors() {
        //TODO
        //You can use the josh hug's solution.Make sure to cite your source.
        return null;
    }

    /** Hamming estimate described below:
     *  The number of tiles in the wrong position. */
    public int hamming() {
        //TODO
        return 0;
    }

    /** Manhattan estimate described below:
     *  The sum of the Manhattan distances (sum of the vertical and horizontal distance)
     *  from the tiles to their goal positions. */
    public int manhattan() {
        //TODO
        return 0;
    }

    /** Estimated distance to goal. This method should simply return the results of
     *  manhattan() when submitted to Gradescope. */
    @Override
    public int estimatedDistanceToGoal() {
        //TODO
        return 0;
    }

    /** Returns true if this board's tile values are the same position as y's */
    @Override
    public boolean equals(Object y) {
        //TODO
        return false;
    }


    /** Returns the string representation of the board. Uncomment this method. */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
