package Graph61B;

import PQ61B.PriorityQueue;

/** notice the MST is only for undirected graph. */
public class PrimMST {
    private double[] distTo;
    private int[] edgeTo;
    private boolean[] marked;
    PriorityQueue<Integer> PQ;
    private int s;

    public PrimMST(EdgeWeightedGraph G, int s) {
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
        prim(G, s);
    }

    public void prim(EdgeWeightedGraph G, int s) {
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
                scan(e, p);
            }
        }
    }

    private void scan(Edge e, int p) {
        int w = e.other(p);
        if (marked[w]) {
            return;
        }
        if (e.weight() < distTo[w]) {
            distTo[w] = e.weight();
            edgeTo[w] = p;
            PQ.changePriority(w, distTo[w]);
        }
    }

    public void path() {
        for (int v = 0; v < distTo.length; v += 1) {
            System.out.println(edgeTo[v] + "-" + v);
        }
    }

    public double sumOfDist() {
        double sum = 0.0;
        for (double tmp : distTo) {
            sum += tmp;
        }
        return sum;
    }

}
