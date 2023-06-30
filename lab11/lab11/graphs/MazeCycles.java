package lab11.graphs;

/**
 *  @author Josh Hug
 *  @ contributor cscourage
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    // default begin at 0.
    private int s;

    //avoid draw the edgeTo array.
    private int[] nodeTo;

    private boolean isFound = false;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        s = 0;
        nodeTo = new int[maze.V()];
    }

    @Override
    public void solve() {
        dfsFounder(s);
    }

    // Helper methods go here
    private void dfsFounder(int v) {
        marked[v] = true;
        announce();
        // recursion exit.
        if (isFound) {
            return;
        }

        for (int w : maze.adj(v)) {
            // find the cycle successfully.
            if (marked[w] && w != nodeTo[v]) {
                isFound = true;
                edgeTo[w] = v;
                announce();
                for (int x = v; x != w; x = nodeTo[x]) {
                    edgeTo[x] = nodeTo[x];
                    announce();
                }
                return;
            }
            if (!marked[w]) {
                nodeTo[w] = v;
                dfsFounder(w);
                // short-circuiting
                if (isFound) {
                    return;
                }
            }
        }
    }
}
