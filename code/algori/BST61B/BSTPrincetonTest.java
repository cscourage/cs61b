package BST61B;

import org.junit.Test;
import static org.junit.Assert.*;

public class BSTPrincetonTest {
    /** I only use one test method, but incrementally add and test.
     *  And you can think the other idea that divide the test into different
     *  parts.
     */
    @Test
    public void testBST() {
        BSTPrinceton<String, Integer> bst = new BSTPrinceton<>();
        bst.put("high", 17);
        bst.put("fly", 19);
        bst.put("blue", 15);
        bst.put("grace", 21);
        bst.put("cat", 8);
        bst.put("default", 3);
        bst.put("less", 0);
        bst.put("josh", 18);
        bst.put("mass", 10);
        assertEquals(9, bst.size());
        assertTrue(bst.contains("josh"));
        assertFalse(bst.contains("hug"));
        assertEquals(21, (int) bst.get("grace"));

        bst.deleteMin();
        assertEquals(8, bst.size());
        assertFalse(bst.contains("blue"));

        bst.deleteMax();
        assertEquals(7, bst.size());
        assertFalse(bst.contains("mass"));

        assertEquals("cat", bst.min());
        bst.delete("high");
        assertEquals(6, bst.size());
        assertFalse(bst.contains("high"));

        assertEquals("less", bst.max());

        assertEquals("grace", bst.floor("hug"));
        assertEquals("grace", bst.floor2("hug"));
        assertEquals("josh", bst.ceiling("hug"));

        assertEquals("cat", bst.select(0));
        assertEquals(1, bst.rank("default"));

        assertEquals(3, bst.height());

        assertEquals(4, bst.rank("i"));

        assertEquals(6, bst.size("cat", "less"));
        assertEquals(4, bst.size("cow", "lay"));

        assertTrue(bst.check());
    }
}