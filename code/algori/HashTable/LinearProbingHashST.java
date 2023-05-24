package HashTable;

public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int M;   //the number of buckets.
    private int N;   //the number of key-value pairs.
    private ST[] buckets;

    public class ST{
        private Key key;
        private Value value;

        public ST() {

        }

        public ST(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /* notice in the LinearProbingHashTable, N > M ensures that it has empty location
    * which can be used to handle collision. */
    public LinearProbingHashST(int capacity) {
        M = capacity;
        buckets = (ST[]) new Object[capacity];
    }

    public int elementSize() {
        return N;
    }

    public int bucketsSize() {
        return M;
    }

    private void resize(int newCapacity) {
        LinearProbingHashST<Key, Value> newHashTable = new LinearProbingHashST<>(newCapacity);
        for (ST temp : buckets) {
            if (temp != null) {
                newHashTable.put(temp.key, temp.value);
            }
        }
        this.M = newHashTable.M;
        this.buckets = newHashTable.buckets;
    }

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
            index += 1;
        }
        buckets[index] = new ST(key, value);
        N += 1;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }


    public void delete(Key key) {

        N -= 1;
        if (M > INIT_CAPACITY && (double) N / M <= 0.125) {
            resize(M / 2);
        }
    }
}
