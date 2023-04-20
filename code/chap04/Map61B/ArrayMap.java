package Map61B;

import java.util.List;
import java.util.ArrayList;

public class ArrayMap<K, V> implements Map61B<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    private int keyFinder(K key) {
        for (int i = 0; i < size; i += 1) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    public void put(K key, V value) {
        int index = keyFinder(key);
        if (index > -1) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size += 1;
        }
    }

    public boolean containsKey(K key) {
        return keyFinder(key) > -1;
    }

    public V get(K key) {
        int index = keyFinder(key);
        return values[index];
    }

    public List<K> keys() {
        List<K> result = new ArrayList<>();
        for (int i = 0; i < size; i += 1) {
            result.add(keys[i]);
        }
        return result;
    }

    public int size() {
        return size;
    }
}
