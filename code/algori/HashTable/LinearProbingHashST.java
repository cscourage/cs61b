package HashTable;

public class LinearProbingHashST<Key, Value> implements Hash<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int M;   //the number of buckets.
    private int N;   //the number of key-value pairs.
    private PST<Key, Value>[] buckets;


    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /* notice in the LinearProbingHashTable, N > M ensures that it has empty location
    * which can be used to handle collision. */
    public LinearProbingHashST(int capacity) {
        M = capacity;
        buckets = new PST[capacity];
    }

    @Override
    public int elementSize() {
        return N;
    }

    @Override
    public int bucketsSize() {
        return M;
    }

    private void resize(int newCapacity) {
        LinearProbingHashST<Key, Value> newHashTable = new LinearProbingHashST<>(newCapacity);
        for (PST temp : buckets) {
            if (temp != null) {
                newHashTable.put((Key) temp.key, (Value) temp.value);
            }
        }
        this.M = newHashTable.M;
        this.buckets = newHashTable.buckets;
    }

    @Override
    public void put(Key key, Value value) {
        if ((double) N / M >= 0.5) {
            resize(M * 2);
        }
        int index = hash(key);
        while (buckets[index] != null) {
            if (key.equals(buckets[index].key)) {
                buckets[index].value = value;
                return;
            }
            index = (index + 1) % M;
        }
        buckets[index] = new PST(key, value);
        N += 1;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public boolean contains(Key key) {
        int index = hash(key);
        while (buckets[index] != null) {
            if (key.equals(buckets[index].key)) {
                return true;
            }
            index = (index + 1) % M;
        }
        return false;
    }


    @Override
    public void delete(Key key) {
        int index = hash(key);
        boolean tag = false;
        while (buckets[index] != null) {
            if (key.equals(buckets[index].key)) {
                tag = true;
                break;
            }
            index = (index + 1) % M;
        }
        if (!tag) {
            throw new IllegalArgumentException("hashTable doesn't have the given key.");
        }
        buckets[index] = null;
        index = (index + 1) % M;
        while (buckets[index] != null) {
            Key tmpkey = buckets[index].key;
            Value tmpvalue = buckets[index].value;
            buckets[index] = null;
            N -= 1;
            put(tmpkey, tmpvalue);
            index = (index + 1) % M;
        }
        N -= 1;
        if (M > INIT_CAPACITY && (double) N / M <= 0.125) {
            resize(M / 2);
        }
    }

    @Override
    public Value get(Key key) {
        int index = hash(key);
        while (buckets[index] != null) {
            if (key.equals(buckets[index].key)) {
                return buckets[index].value;
            }
            index = (index + 1) % M;
        }
        throw new IllegalArgumentException("HashTable doesn't have the key");
    }
}
