package SpatialTree;

import static org.junit.Assert.*;
import org.junit.Test;

public class testSpatialTree {
    @Test
    public void testQuadTree1() {
        QuadTree<String> qt = new QuadTree<>();
        qt.put("A", -1, -1);
        qt.put("B", 2, 2);
        qt.put("C", 0, 1);
        qt.put("D", 1, 0);
        qt.put("E", -2, -2);
        assertEquals(5, qt.size());
        qt.put("F", 2, 2);
        assertEquals(5, qt.size());

        assertEquals("D", qt.query(1, 0));
    }

    @Test
    public void testQuadTree2() {
        QuadTree<String> qt = new QuadTree<>();
        qt.put("D", 1, 0);
        qt.put("A", -1, -1);
        qt.put("B", 2, 2);
        qt.put("E", -2, -2);
        qt.put("C", 0, 1);
        assertEquals(5, qt.size());
        assertEquals("E", qt.query(-2, -2));
    }
}
