package LLRB61B;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLLRBMap {
    @Test
    public void testLLRB() {
        LLRBMap<String, Integer> llrb = new LLRBMap<>();
        llrb.put("ao", 1);
        llrb.put("bee", 2);
        llrb.put("cow", 3);
        llrb.put("do", 4);
        llrb.put("egg", 5);
        llrb.put("fetch", 6);
        llrb.put("glue", 7);

        assertTrue(llrb.contains("ao"));
        assertTrue(llrb.contains("bee"));
        assertTrue(llrb.contains("cow"));
        assertTrue(llrb.contains("do"));
        assertTrue(llrb.contains("egg"));
        assertTrue(llrb.contains("fetch"));
        assertTrue(llrb.contains("glue"));

        assertEquals(7, llrb.size());
    }
}
