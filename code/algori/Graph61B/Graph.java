package Graph61B;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    /** implemented by adjacent list. */
    private final int V;
    private List<Integer>[] adj;
    private int E;

    /** Create empty graph with v vertices. */
    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v += 1) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    /** add an edge v-w. */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E += 1;
    }

    /** vertices adjacent to v. */
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /** number of vertices. */
    int V() {
        return V;
    }

    /** number of edges. */
    int E() {
        return E;
    }
}
