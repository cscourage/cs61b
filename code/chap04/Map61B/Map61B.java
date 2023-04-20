package Map61B;

import java.util.List;

public interface Map61B<K, V> {
    void put(K key, V value);
    boolean containsKey(K key);
    V get(K key);
    List<K> keys();
    int size();
}
