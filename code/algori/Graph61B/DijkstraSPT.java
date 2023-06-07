package Graph61B;

import PQ61B.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DijkstraSPT {
    private double[] distTo;
    private int[] edgeTo;
    /** note we can also not use marked, but we need add a contains method in our pq class.
     *  but you know, it will limit the class's integer index 0~size-1.
     *  for example, 0,1,2,3,4,5 is permitted. but 1,5,6,7 is not permitted.
     *  because if we want run O(1) in contains method ,we check if the input in 0~size-1.
     *  so it will spoil the pq class not to be generic, and that we add the marked array here. */
    private boolean[] marked;
    PriorityQueue<Integer> PQ;
    private int s;

    public DijkstraSPT(EdgeWeightedGraph G, int s) {
        int number = G.V();
        distTo = new double[number];
        for (int v = 0; v < number; v += 1) {
            distTo[v] = Double.MAX_VALUE;
        }
        distTo[s] = 0.0;
        edgeTo = new int[number];
        marked = new boolean[number];
        PQ = new PriorityQueue<>(number);
        this.s = s;
        dijkstra(G, s);
    }

    private void dijkstra(EdgeWeightedGraph G, int s) {
        PQ.insert(s, 0);
        for (int v = 0; v < G.V(); v += 1) {
            if (v != s) {
                PQ.insert(v, Double.MAX_VALUE);
            }
        }
        while (!PQ.isEmpty()) {
            int p = PQ.removeMin();
            marked[p] = true;
            for (Edge e : G.adj(p)) {
                relax(e, p);
            }
        }
    }

    private void relax(Edge e, int p) {
        int w = e.other(p);
        if (marked[w]) {
            return;
        }
        if (distTo[p] + e.weight() < distTo[w]) {
            distTo[w] = distTo[p] + e.weight();
            edgeTo[w] = p;
            PQ.changePriority(w, distTo[w]);
        }
    }

    /** path from s to v (if any). */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    /** is there a path from s to v? */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public double minimumPath(int v) {
        return distTo[v];
    }
}
