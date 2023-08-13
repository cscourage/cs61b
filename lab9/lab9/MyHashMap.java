package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author cscourage.
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private int loadFactor() {
        return size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* it is for resizing. */
    public MyHashMap(int capacity) {
        buckets = new ArrayMap[capacity];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        int index = hash(key);
        return buckets[index].get(key);
    }

    /* Associates the specified value with the specified key in this map. */
    /** the below two size statement is to avoid edit an item but not add an item.
     *  so the size will not increase.
     */
    @Override
    public void put(K key, V value) {
        int index = hash(key);
        size -= buckets[index].size;
        buckets[index].put(key, value);
        size += buckets[index].size;
        if (loadFactor() > MAX_LF) {
            resize(buckets.length * 2);
        }
    }

    private void resize(int capacity) {
        MyHashMap<K, V> newHash = new MyHashMap<>(capacity);
        for (ArrayMap<K, V> bucket : buckets) {
            for (K key : bucket) {
                newHash.put(key, bucket.get(key));
            }
        }
        this.buckets = newHash.buckets;
        this.size = newHash.size;
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> ret = new HashSet<>();
        for (ArrayMap<K, V> bucket : buckets) {
            ret.addAll(bucket.keySet());
        }
        return ret;
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        int index = hash(key);
        size -= buckets[index].size;
        V retValue = buckets[index].remove(key);
        size += buckets[index].size;
        return retValue;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        int index = hash(key);
        size -= buckets[index].size;
        V retValue = buckets[index].remove(key, value);
        size += buckets[index].size;
        return retValue;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
