package Graph61B;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private List<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Edge>[]) new ArrayList[V];
        for (int v = 0; v < V; v += 1) {
            adj[v] = new ArrayList<Edge>();
        }
    }

    public void addEdge(int v, int w, double weight) {
        Edge edge = new Edge(v, w, weight);
        adj[v].add(edge);
        adj[w].add(edge);
        E += 1;
    }

    Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}
