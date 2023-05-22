package Tries;

public interface Trie<Value> {
    public int size();
    public Value get(String key);
    public boolean contains(String key);
    public void put(String key, Value val);

}
