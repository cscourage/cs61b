package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author cscourage.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            return getHelper(key, p.left);
        } else if (key.compareTo(p.key) > 0) {
            return getHelper(key, p.right);
        } else {
            return p.value;
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument key shouldn't be null.");
        }
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size += 1;
            return new Node(key, value);
        }
        if (key.compareTo(p.key) < 0) {
            p.left = putHelper(key, value, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = putHelper(key, value, p.right);
        } else {
            p.value = value;
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("argument key is null.");
        }
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    /** I use the in-order traversal. but you will find the result may be not
     *  same as the order from small to big. Because the it is hashset not list.
     * @author courage
     */
    @Override
    public Set<K> keySet() {
        Set<K> ret = new HashSet<>();
        keySetHelper(ret, root);
        return ret;
    }

    private void keySetHelper(Set<K> ret, Node x) {
        if (x == null) {
            return;
        }
        keySetHelper(ret, x.left);
        ret.add(x.key);
        keySetHelper(ret, x.right);
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        V retValue = get(key);
        if (retValue == null) {
            return null;
        }
        root = removeHelper(key, root);
        size -= 1;
        return retValue;
    }

    private Node removeHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            p.left = removeHelper(key, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = removeHelper(key, p.right);
        } else {
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {
                Node successor = findMin(p.right);
                p.key = successor.key;
                p.value = successor.value;
                p.right = removeHelper(key, p.right);
            }
        }
        return p;
    }

    private Node findMin(Node p) {
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        V retValue = get(key);
        if (retValue == null || retValue != value) {
            return null;
        }
        root = removeHelper(key, value, root);
        size -= 1;
        return retValue;
    }

    private Node removeHelper(K key, V value, Node p) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            p.left = removeHelper(key, value, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = removeHelper(key, value, p.right);
        } else {
            if (p.value != value) {
                return p;
            }
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {
                Node successor = findMin(p.right);
                p.key = successor.key;
                p.value = successor.value;
                p.right = removeHelper(key, value, p.right);
            }
        }
        return p;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
