package Tries;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestTries {
    @Test
    public void testSizeAndGet() {
        Trie<Integer> tr = new TrieST<>();
        assertEquals(0, tr.size());
        tr.put("she", 0);
        tr.put("sells", 1);
        tr.put("sea", 2);
        tr.put("shells", 3);
        tr.put("by", 4);
        tr.put("the", 5);
        assertEquals(2, (int) tr.get("sea"));
        tr.put("sea", 6);
        assertEquals(6, (int) tr.get("sea"));
        tr.put("shore", 7);
        assertEquals(7, tr.size());
        assertTrue(tr.contains("the"));
        assertFalse(tr.contains("shout"));
    }
}
