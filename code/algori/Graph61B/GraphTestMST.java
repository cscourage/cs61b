package Graph61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTestMST {
    /** notice the MST is only for undirected graph. */
    @Test
    public void testPrimMST() {
        /** test the graph constructor. */
        EdgeWeightedGraph G = new EdgeWeightedGraph(7);
        G.addEdge(0, 1, 2, false);
        G.addEdge(0, 2, 1, false);
        G.addEdge(1, 2, 5, false);
        G.addEdge(1, 3, 11, false);
        G.addEdge(1, 4, 3, false);
        G.addEdge(2, 5, 15, false);
        G.addEdge(3, 4, 2, false);
        G.addEdge(4, 2, 1, false);
        G.addEdge(4, 5, 4, false);
        G.addEdge(4, 6, 5, false);
        G.addEdge(6, 3, 1, false);
        G.addEdge(6, 5, 1, false);
        assertEquals(7, G.V());
        assertEquals(12, G.E());

        /** test primMST */
        PrimMST primClient = new PrimMST(G, 0);
        assertEquals(8, primClient.sumOfDist(), 0.0001);
        //System.out.println(primClient.path());
        primClient.path();
    }
}
