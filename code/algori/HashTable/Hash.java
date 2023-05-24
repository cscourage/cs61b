package HashTable;

public interface Hash<Key, Value> {
    public int elementSize();
    public int bucketsSize();
    public void put(Key key, Value value);
    public boolean contains(Key key);
    public void delete(Key key);
    public Value get(Key key);
}
