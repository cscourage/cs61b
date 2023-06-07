package Graph61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTestDijkstra {
    @Test
    public void testUndirectedDijkstra() {
        /** test the graph constructor. */
        EdgeWeightedGraph G = new EdgeWeightedGraph(8);
        G.addEdge(0, 1, 70);
        G.addEdge(0, 2, 260);
        G.addEdge(0, 3, 10);
        G.addEdge(2, 3, 70);
        G.addEdge(2, 4, 70);
        G.addEdge(3, 7, 50);
        G.addEdge(4, 5, 40);
        G.addEdge(5, 6, 20);
        G.addEdge(5, 7, 30);
        G.addEdge(6, 7, 15);
        assertEquals(8, G.V());
        assertEquals(10, G.E());
        //System.out.println(G.adj(0));


        /** test Dijkstra. */
        DijkstraSPT dijkstraClient = new DijkstraSPT(G, 0);
        assertTrue(dijkstraClient.hasPathTo(5));
        System.out.println(dijkstraClient.pathTo(4));
        assertEquals(130, dijkstraClient.minimumPath(4), 0.0001);
    }
}
