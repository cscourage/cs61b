package HashTable;

import static org.junit.Assert.*;
import org.junit.Test;

public class testHashTable {
    /* incrementally add test. */
    @Test
    public void testSeparateChainingHashTable() {
        SeparateChainingHashST<String, Integer> hashTable = new SeparateChainingHashST<>();
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
        LinearProbingHashST<String, Integer> hashTable = new LinearProbingHashST<>();
        hashTable.put("josh", 100);
        hashTable.put("hug", 90);
    }
}
