package lab11.graphs;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  @author Josh Hug
 *  @ contributor cscourage
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        Queue<Integer> fringe = new ArrayDeque<>();
        marked[s] = true;
        announce();
        fringe.add(s);
        while (!fringe.isEmpty()) {
            int v = fringe.poll();
            if (v == t) {
                targetFound = true;
                return;
            }
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    announce();
                    if (w == t) {
                        targetFound = true;
                        return;
                    }
                    fringe.add(w);
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

