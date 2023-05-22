package Tries;

public class TrieST<Value> implements Trie<Value> {
    private static final int R = 128;
    private Node root;
    private int size;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public TrieST() {

    }

    @Override
    // immediate implementation
    public int size() {
        return size;
    }

    @Override
    /* for the given key, get the value. */
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    /* the helper method of get. */
    private Node get(Node x, String key, int d) {
        // fall out of the tree
        if (x == null) {
            return null;
        }
        // get the white or blue node. if white node, x.val == null.
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    @Override
    /* check if the tree has the key. */
    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    /* put the key-value pairs into the tree. */
    public void put(String key, Value val) {
        if (!contains(key)) {
            size += 1;
        }
        root = put(root, key, val, 0);
    }

    /* the helper method of put. */
    private Node put(Node x, String key, Value val, int d) {
        // if reach the null node, create a new node.
        if (x == null) {
            x = new Node();
        }
        // if reach the end, put the value and return.
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }
}
