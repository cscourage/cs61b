package Map61B;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMapTest {
    @Test
    public void test() {
        ArrayMap<Integer, Integer> mp = new ArrayMap<Integer, Integer>();
        mp.put(2, 5);
        int expected = 5;
        assertEquals((Integer) expected, mp.get(2));
    }

    /*
    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 1);
        m.put("fish", 10);
        m.put("horse", 5);
    }*/
}
