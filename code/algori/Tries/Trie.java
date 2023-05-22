package Tries;

public interface Trie<Value> {
    public int size();
    public Value get(String key);
    public boolean contains(String key);
    public void put(String key, Value val);
    public Iterable<String> keys();
    public Iterable<String> keysWithPrefix(String pre);
    public Iterable<String> keysThatMatch(String pat);
    public String longestPrefixOf(String s);
}
