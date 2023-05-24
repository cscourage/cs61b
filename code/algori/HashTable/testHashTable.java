package HashTable;

import static org.junit.Assert.*;
import org.junit.Test;

public class testHashTable {
    /* incrementally add test. */
    @Test
    public void testSeparateChainingHashTable() {
        Hash<String, Integer> hashTable = new SeparateChainingHashST<>();
        hashTable.put("josh", 100);
        hashTable.put("hug", 90);
        hashTable.put("Tyrone", 94);
        hashTable.put("bob", 10);
        hashTable.put("alice", 20);
        hashTable.put("tina", 5);
        assertEquals(6, hashTable.elementSize());
        assertEquals(4, hashTable.bucketsSize());
        hashTable.put("hug", 91);
        assertEquals(6, hashTable.elementSize());
        assertEquals(8, hashTable.bucketsSize());

        assertTrue(hashTable.contains("Tyrone"));
        assertFalse(hashTable.contains("alin"));

        hashTable.delete("hug");
        assertEquals(5, hashTable.elementSize());
        assertEquals(8, hashTable.bucketsSize());

        hashTable.delete("alice");
        assertEquals(4, hashTable.elementSize());
        assertEquals(4, hashTable.bucketsSize());

        assertEquals(100, (int) hashTable.get("josh"));
    }

    @Test
    public void testLinearProbingHashTable() {
        Hash<String, Integer> hashTable = new LinearProbingHashST<>();
        hashTable.put("josh", 100);
        hashTable.put("hug", 90);
        assertEquals(2, hashTable.elementSize());
        assertEquals(4, hashTable.bucketsSize());
        hashTable.put("alice", 10);
        assertEquals(3, hashTable.elementSize());
        assertEquals(8, hashTable.bucketsSize());

        assertTrue(hashTable.contains("hug"));
        assertFalse(hashTable.contains("bob"));

        hashTable.put("Tyrone", 94);
        hashTable.put("bob", 20);
        assertEquals(5, hashTable.elementSize());
        assertEquals(16, hashTable.bucketsSize());

        assertEquals(94, (int) hashTable.get("Tyrone"));
        hashTable.delete("josh");
        hashTable.delete("bob");
        hashTable.delete("alice");
        assertEquals(2, hashTable.elementSize());
        assertEquals(8, hashTable.bucketsSize());
        hashTable.delete("Tyrone");
        assertEquals(1, hashTable.elementSize());
        assertEquals(4, hashTable.bucketsSize());
    }
}
