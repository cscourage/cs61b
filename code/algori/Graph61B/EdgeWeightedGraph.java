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

    /** for directed graph, what we will to do is only add the specific one in the adj not the two both.
     *  tag true for directed graph, false for undirected graph. */
    public void addEdge(int v, int w, double weight, boolean tag) {
        Edge edge = new Edge(v, w, weight);
        adj[v].add(edge);
        if (!tag) {
            adj[w].add(edge);
        }
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

    public Iterable<Edge> edges() {
        List<Edge> edgeList = new ArrayList<>();
        for (int v = 0; v < V; v += 1) {
            for (Edge e : adj(v)) {
                edgeList.add(e);
            }
        }
        return edgeList;
    }
}
