package Graph61B;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

public class KruskalMST {
    private List<Edge> mst = new ArrayList<>();

    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>(G.V());
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
            }
        }
    }

    public double sumOfDist() {
        double sum = 0.0;
        for (Edge e : mst) {
            sum += e.weight();
        }
        return sum;
    }

    public void path() {
        for (Edge e : mst) {
            int v = e.either();
            int w = e.other(v);
            System.out.println(v + "-" + w);
        }
    }
}
