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
        assertEquals(7, ((TrieST) tr).size_recursion());
        assertTrue(tr.contains("the"));
        assertFalse(tr.contains("shout"));
    }

    @Test
    public void testStringOperation() {
        Trie<Integer> tr = new TrieST<>();
        tr.put("by", 4);
        tr.put("sea", 6);
        tr.put("sells", 1);
        tr.put("she", 0);
        tr.put("shells", 3);
        tr.put("shore", 7);
        tr.put("the", 5);
        System.out.println(tr.keys());
        System.out.println(tr.keysWithPrefix("sh"));
    }

    @Test
    public void testKeysThatMatch() {
        Trie<Integer> tr = new TrieST<>();
        tr.put("by", 4);
        tr.put("sea", 6);
        tr.put("sells", 1);
        tr.put("she", 0);
        tr.put("shells", 3);
        tr.put("shore", 7);
        tr.put("the", 5);
        System.out.println(tr.keysThatMatch(".he"));
        System.out.println(tr.keysThatMatch("s.."));
    }

    @Test
    public void testLongestPrefixOf() {
        Trie<Integer> tr = new TrieST<>();
        tr.put("sea", 2);
        tr.put("sells", 1);
        tr.put("she", 0);
        tr.put("shells", 3);
        assertEquals("she", tr.longestPrefixOf("she"));
        assertEquals("she", tr.longestPrefixOf("shell"));
        assertEquals("shells", tr.longestPrefixOf("shellsort"));
        assertEquals("she", tr.longestPrefixOf("shelters"));
    }

    @Test
    public void testDelete() {
        Trie<Integer> tr = new TrieST<>();
        tr.put("sea", 2);
        tr.put("sells", 1);
        tr.put("she", 0);
        tr.put("shells", 3);
        tr.delete("shells");
        assertFalse(tr.contains("shells"));
        assertTrue(tr.contains("sea"));
        assertTrue(tr.contains("she"));
        assertTrue(tr.contains("sells"));
    }

}
