package HashTable;

import java.util.ArrayList;

public class SeparateChainingHashST<Key, Value> implements Hash<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int M;   //the number of buckets.
    private int N;   //the number of key-value pairs.
    private ArrayList<ST>[] buckets;  //the buckets which based on arraylist.

    private class ST {
        private Key key;
        private Value value;

        public ST(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        /* there we redefine the hashCode of the new constructed class ST using "base" strategy.
           But we may not use it. */
        public int hashCode() {
            return key.hashCode() * 31 + value.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null) {
                return false;
            }
            if (other.getClass() != this.getClass()) {
                return false;
            }
            ST o = (ST) other;
            return key == o.key && value == o.value;
        }
    }

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int capacity) {
        M = capacity;
        /* note the generic array's declaration and construction. */
        buckets = (ArrayList<ST>[]) new ArrayList<?>[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<ST>();
        }
    }

    @Override
    public int elementSize() {
        return N;
    }

    @Override
    public int bucketsSize() {
        return M;
    }

    /* resize the array when necessary. */
    private void resize(int newCapacity) {
        SeparateChainingHashST<Key, Value> newHashTable = new SeparateChainingHashST<>(newCapacity);
        for (int i = 0; i < M; i += 1) {
            for (int j = 0; j < buckets[i].size(); j += 1) {
                /* In the arraylist, the get method takes constant time. So it is similar
                * to the next. */
                ST temp = buckets[i].get(j);
                newHashTable.put(temp.key, temp.value);
            }
        }
        this.M = newHashTable.M;
        this.buckets = newHashTable.buckets;
    }

    @Override
    /* put the key-value pair into the SeparateChainingHashTable. */
    public void put(Key key, Value value) {
        if ((double) N / M >= 1.5) {
            resize(M * 2);
        }
        int index = hash(key);
        ST tmp = new ST(key, value);
        /* simulate move on and check if there already has the given-pairs. */
        ArrayList<ST> target = buckets[index];
        for (int i = 0; i < target.size(); i += 1) {
            if (key.equals(target.get(i).key)) {
                target.set(i, tmp);
                return;
            }
        }
        /* it takes constant time. */
        target.add(tmp);
        N += 1;
    }

    /* there we use key's hash not the ST's hash, because we must think
    *  about the condition that we put the key into the hashtable as well as
    *  value. We care about the key not be repetitive. */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public boolean contains(Key key) {
        int index = hash(key);
        ArrayList<ST> target = buckets[index];
        for (ST st : target) {
            if (key.equals(st.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(Key key) {
        int index = hash(key);
        ArrayList<ST> target = buckets[index];
        int pos = -1;
        for (int i = 0; i < target.size(); i += 1) {
            if (key.equals(target.get(i).key)) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            throw new IllegalArgumentException("hashTable doesn't have the given key.");
        } else {
            target.remove(pos);
        }
        N -= 1;
        /* resize. */
        if (M > INIT_CAPACITY && (double) N / M <= 0.5) {
            resize(M / 2);
        }
    }

    @Override
    public Value get(Key key) {
        int index = hash(key);
        ArrayList<ST> target = buckets[index];
        for (ST st : target) {
            if (key.equals(st.key)) {
                return st.value;
            }
        }
        throw new IllegalArgumentException("HashTable doesn't have the key");
    }

}
