package Map61B;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class MapHelper {
    public static <K, V> V get(Map61B<K, V> map, K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keyList = map.keys();
        K largest = keyList.get(0);
        for (K k : keyList) {
            if (k.compareTo(largest) > 0) {
                largest = k;
            }
        }
        return largest;
    }


    @Test
    public void testGet() {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);

        assertEquals(null, MapHelper.get(m, "nihaoa"));

    }

    @Test
    public void testMaxKey() {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);

    }
}
