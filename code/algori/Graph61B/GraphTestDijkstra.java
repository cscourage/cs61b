package Graph61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTestDijkstra {
    @Test
    public void testUndirectedDijkstra() {
        /** test the graph constructor. */
        EdgeWeightedGraph G = new EdgeWeightedGraph(8);
        G.addEdge(0, 1, 70, false);
        G.addEdge(0, 2, 260, false);
        G.addEdge(0, 3, 10, false);
        G.addEdge(2, 3, 70, false);
        G.addEdge(2, 4, 70, false);
        G.addEdge(3, 7, 50, false);
        G.addEdge(4, 5, 40, false);
        G.addEdge(5, 6, 20, false);
        G.addEdge(5, 7, 30, false);
        G.addEdge(6, 7, 15, false);
        assertEquals(8, G.V());
        assertEquals(10, G.E());
        //System.out.println(G.adj(0));


        /** test Dijkstra. */
        DijkstraSPT dijkstraClient = new DijkstraSPT(G, 0);
        assertTrue(dijkstraClient.hasPathTo(5));
        System.out.println(dijkstraClient.pathTo(4));
        assertEquals(130, dijkstraClient.minimumPath(4), 0.0001);
    }

    @Test
    public void testDirectedDijkstra() {
        /** test the graph constructor. */
        EdgeWeightedGraph G = new EdgeWeightedGraph(7);
        G.addEdge(0, 1, 2, true);
        G.addEdge(0, 2, 1, true);
        G.addEdge(1, 2, 5, true);
        G.addEdge(1, 3, 11, true);
        G.addEdge(1, 4, 3, true);
        G.addEdge(2, 5, 15, true);
        G.addEdge(3, 4, 2, true);
        G.addEdge(4, 2, 1, true);
        G.addEdge(4, 5, 4, true);
        G.addEdge(4, 6, 5, true);
        G.addEdge(6, 3, 1, true);
        G.addEdge(6, 5, 1, true);
        assertEquals(7, G.V());
        assertEquals(12, G.E());
        //System.out.println(G.adj(0));


        /** test Dijkstra. */
        DijkstraSPT dijkstraClient = new DijkstraSPT(G, 0);
        assertTrue(dijkstraClient.hasPathTo(5));
        System.out.println(dijkstraClient.pathTo(3));
        assertEquals(5, dijkstraClient.minimumPath(4), 0.0001);
    }
}
