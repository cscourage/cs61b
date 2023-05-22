package Tries;

import edu.princeton.cs.algs4.Queue;

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

    public int size_recursion() {
        return size_recursion_helper(root);
    }

    private int size_recursion_helper(Node x) {
        // Base case.
        if (x == null) {
            return 0;
        }
        int cnt = 0;
        if (x.val != null) {
            cnt += 1;
        }
        for (char c = 0; c < R; c++) {
            cnt += size_recursion_helper(x.next[c]);
        }
        return cnt;
    }

    @Override
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    @Override
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            q.enqueue(pre);
        }
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    @Override
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        // if fall out of the tree.
        if (x == null) {
            return;
        }
        // upon reaching the length, it ends.
        // if x.val != null, append the String pre.
        if (d == pat.length()) {
            if (x.val != null) {
                q.enqueue(pre);
            }
            return;
        }
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    @Override
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        // fall out of the tree.
        if (x == null) {
            return length;
        }
        // If reach a key then set the length.It ensures the longest.
        if (x.val != null) {
            length = d;
        }
        // reach the length.
        if (d == s.length()) {
            return length;
        }
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    @Override
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    /* the helper method of delete. */
    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) {
            return x;
        }
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }
}
