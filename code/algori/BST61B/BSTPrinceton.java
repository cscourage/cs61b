package BST61B;

import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class BSTPrinceton<Key extends Comparable<Key>, Value> {
    private Node root;    //root of BST

    private class Node {
        private Key key;             //sorted by key.
        private Value value;         //associated data.
        private Node left, right;    //left and right subtree.
        private int size;            //number of nodes in subtree.

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    /* Initialize an empty symbol table. */
    public BSTPrinceton() {
    }

    /* Return true if this symbol table is Empty. */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* return the number of key-value pairs in this symbol table. */
    public int size() {
        return size(root);
    }

    /* the helper method: return number of key-value pairs in BST rooted at x. */
    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    /* return if this symbol table contains the given key. */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() is null.");
        }
        return get(key) != null;
    }

    /* return the value associated with the given key. */
    public Value get(Key key) {
        return get(root, key);
    }

    /* the helper method of get. */
    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key.");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    /* Insert the key-value pair into the symbol table. */
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with a null key.");
        }
        if (value == null) {
            //delete(key);
            return;
        }
        root = put(root, key, value);
        //assert check();
    }

    /* the helper method of put. */
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* delete the smallest key and associated value from the symbol table. */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow.");
        }
        root = deleteMin(root);
        //assert check();
    }

    /* the helper method of deleteMin. */
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* remove the largest key and associated value from the symbol table. */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow.");
        }
        root = deleteMax(root);
        //assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* remove the specified key and its associated value from this symbol table. */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls delete() with a null key.");
        }
        root = delete(root, key);
        //assert check();
    }

    /* the helper method of delete. */
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                Node successor = min(x.right);
                x.key = successor.key;
                x.value = successor.value;
                x.right = deleteMin(x.right);
            }
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* return the smallest key in the symbol table. */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table.");
        }
        return min(root).key;
    }

    /* the helper method of min. */
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    /* return the largest key in the symbol table. */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table.");
        }
        return max(root).key;
    }

    /* the helper method of max. */
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    /* return the largest key in the symbol table less than or equal to the given key. */
    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null.");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls floor() with empty symbol table.");
        }
        Node x = floor(root, key);
        if (x == null) {
            throw new NoSuchElementException("argument to floor() is too small.");
        } else {
            return x.key;
        }
    }

    /* the helper method of floor. */
    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);
        } else {
            Node tmp = floor(x.right, key);
            if (tmp != null) {
                return tmp;
            } else {
                return x;
            }
        }
    }

    public Key floor2(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to floor2() is null.");
        }
        Key x = floor2(root, key, null);
        if (x == null) {
            throw new NoSuchElementException("argument to floor2() is too small.");
        } else {
            return x;
        }
    }

    /* the helper method of floor2. */
    private Key floor2(Node x, Key key, Key best) {
        if (x == null) {
            return best;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return floor2(x.left, key, best);
        } else if (cmp > 0) {
            return floor2(x.right, key, x.key);
        } else {
            return x.key;
        }
    }

    /* return the smallest key in the symbol table greater than or equal to the given key. */
    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null.");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls ceiling() with empty symbol table.");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            throw new NoSuchElementException("argument to ceiling() is too large.");
        } else {
            return x.key;
        }
    }

    /* the helper method of ceiling. */
    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp > 0) {
            return ceiling(x.right, key);
        } else {
            Node tmp = ceiling(x.left, key);
            if (tmp != null) {
                return tmp;
            } else {
                return x;
            }
        }
    }

    /* return the key in the symbol table of a given rank. */
    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select is invalid : " + rank);
        }
        return select(root, rank);
    }

    /* the helper method of select. */
    private Key select(Node x, int rank) {
        if (x == null) {
            return null;
        }
        int leftSize = size(x.left);
        if (leftSize > rank) {
            return select(x.left, rank);
        } else if (leftSize < rank) {
            return select(x.right, rank - leftSize - 1);
        } else {
            return x.key;
        }
    }

    /* return the number of keys in the symbol table strictly less than the given key. */
    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank is null.");
        }
        return rank(root, key);
    }

    /* the helper method of rank. */
    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }

    /* return the height of the BST. */
    public int height() {
        return height(root);
    }

    /* the helper method of height. */
    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /* return the number of keys in the symbol table in the given range. */
    public int size(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("first argument to size() is null.");
        }
        if (hi == null) {
            throw new IllegalArgumentException("second argument to size() is null.");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    /** The following code is to check integrity of BST data structure.
     */
    public boolean check() {
        if (!isBST()) {
            StdOut.println("Not in symmetric order.");
        }
        if (!isSizeConsistent()) {
            StdOut.println("Subtree counts not consistent.");
        }
        return isBST() && isSizeConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict.
    private boolean isBST() {
        return isBST(root, null, null);
    }

    /* the helper method of isBST. */
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) {
            return true;
        }
        if (min != null && x.key.compareTo(min) <= 0) {
            return false;
        }
        if (max != null && x.key.compareTo(max) >= 0) {
            return false;
        }
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    /* the helper method of isSizeConsistent. */
    private boolean isSizeConsistent(Node x) {
        if (x == null) {
            return true;
        }
        if (x.size != size(x.left) + size(x.right) + 1) {
            return false;
        }
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

}
