package Graph61B;

public class GraphClients {
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree += 1;
        }
        return degree;
    }

    public static void print(Graph G) {
        for (int v = 0; v < G.V(); v += 1) {
            for (int w : G.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v += 1) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /** undirected graph. */
    public static double avgDegree(Graph G) {
        return (double) 2 * G.E() / G.V();
    }
}
