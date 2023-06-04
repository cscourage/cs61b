package Graph61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class GraphFirstTest {
    @Test
    public void testUndirectedGraph() {
        /** test the graph constructor. */
        Graph G = new Graph(9);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(1, 4);
        G.addEdge(2, 5);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
        G.addEdge(5, 6);
        G.addEdge(6, 7);
        G.addEdge(5, 8);
        assertEquals(9, G.V());
        assertEquals(9, G.E());
        System.out.println(G.adj(1));

        /** test the clients. */
        assertEquals(3, GraphClients.degree(G, 4));
        assertEquals(4, GraphClients.maxDegree(G));
        assertEquals(2, GraphClients.avgDegree(G), 0.0001);
        //GraphClients.print(G);

        /** test DFS. */
        DepthFirstPaths dfsClient = new DepthFirstPaths(G, 0);
        assertTrue(dfsClient.hasPathTo(5));
        System.out.println(dfsClient.pathTo(7));

        /** test BFS. */
        BreadthFirstPaths bfsClient = new BreadthFirstPaths(G, 0);
        assertTrue(bfsClient.hasPathTo(5));
        assertEquals(3, bfsClient.minimumPath(3));
        assertEquals(5, bfsClient.minimumPath(7));
        System.out.println(bfsClient.pathTo(7));
    }
}
