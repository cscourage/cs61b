package lab11.graphs;

import edu.princeton.cs.algs4.IndexMinPQ;

/**
 *  @author Josh Hug
 *  @ contributor cscourage.
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    IndexMinPQ<Integer> PQ;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        PQ = new IndexMinPQ<>(maze.V());
    }

    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        return Math.abs(maze.toX(v) - maze.toX(t)) + Math.abs(maze.toY(v) - maze.toY(t));
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        PQ.insert(s, 0);
        for (int i = 0; i < maze.V(); i += 1) {
            if (i != s) {
                PQ.insert(i, Integer.MAX_VALUE);
            }
        }
        while (!PQ.isEmpty()) {
            int p = PQ.delMin();
            marked[p] = true;
            announce();
            if (p == t) {
                targetFound = true;
                return;
            }
            for (int w : maze.adj(p)) {
                relax(w, p);
            }
        }
    }

    private void relax(int w, int p) {
        if (marked[w]) {
            return;
        }
        if (distTo[p] + 1 < distTo[w]) {
            distTo[w] = distTo[p] + 1;
            edgeTo[w] = p;
            announce();
            PQ.changeKey(w, distTo[w] + h(w));
        }
    }

    @Override
    public void solve() {
        astar(s);
    }

}

