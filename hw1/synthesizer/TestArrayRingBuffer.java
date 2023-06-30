package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        for (int i = 9; i >= 0; i--) {
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
        for (int i = 0; i < 5; i++) {
            arb.dequeue();
        }
        assertEquals(arb.fillCount(), 5);
        for (int i = 0; i < 5; i++) {
            arb.enqueue(i + 10);
        }
        assertEquals(4, arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
