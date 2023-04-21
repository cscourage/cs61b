package Map61B;

import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;

public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K> {
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public Iterator<K> iterator() {
        return new KeyIterator();
        /*
        List<K> keyList = keys();
        return keyList.iterator();
         */
    }

    private class KeyIterator implements Iterator<K> {
        private int wizardPosition;

        public KeyIterator() {
            wizardPosition = 0;
        }

        public boolean hasNext() {
            return wizardPosition < size;
        }

        public K next() {
            K returnVal = keys[wizardPosition];
            wizardPosition += 1;
            return returnVal;
        }
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

    /* notice A bug was intentionally created here. */
    public V get(K key) {
        int index = keyFinder(key);
        if (index == -1) {
            throw new IllegalArgumentException("key " + key + "doesn't exit in map.\n");
        }
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
