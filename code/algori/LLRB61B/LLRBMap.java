package LLRB61B;

public class LLRBMap<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        boolean color;

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node h) {
        if (h == null) {
            return false;
        }
        return h.color;
    }

    public int size() {
        return size(root);
    }

    private int size(Node h) {
        if (h == null) {
            return 0;
        } else {
            return h.N;
        }
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /* Note that the root's color is always black. */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /** 1. The Node which will be inserted is always red link.
     *  2. Insert using the idea of "binary search".
     *  3. If the right link is red and left link is black, use rotateLeft;
     *     If the left link is red and left link's link is red, use rotateRight;
     *     If the left link and right link are both red, flip colors.
     */
    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public boolean contains(Key key) {
        return contains(root, key);
    }

    /** 1. If the key is smaller than the current node's key, search node's left;
     *  2. Else if the key is bigger than the current node's key, search node's right;
     *  3. Else, we find it;
     *  4. Node if the node is null, just return false;
     */
    private boolean contains(Node h, Key key) {
        if (h == null) {
            return false;
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            return contains(h.left, key);
        } else if (cmp > 0) {
            return contains(h.right, key);
        } else {
            return true;
        }
    }
}
