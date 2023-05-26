package SpatialTree;

public class QuadTree<Key> {
    private QTNode root;

    public QuadTree() {

    }

    public int size() {
        return size(root);
    }

    private int size(QTNode x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public void put(Key key, int x, int y) {
        root = put(root, key, x, y);
    }

    private int compare(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return -1;
        }
        //NW NE SE SW -> 0 1 2 3
        if (x2 > x1 && y2 > y1) {
            return 1;
        } else if (x2 < x1 && y2 > y1) {
            return 0;
        } else if (x2 < x1 && y2 < y1) {
            return 3;
        } else {
            return 2;
        }
    }

    private QTNode put(QTNode node, Key key, int x, int y) {
        if (node == null) {
            return new QTNode(key, x, y, 1);
        }
        int cmp = compare(node.x, node.y, x, y);
        if (cmp == -1) {
            node.key = key;
        } else {
            node.children[cmp] = put(node.children[cmp], key, x, y);
        }
        node.size = size(node.children[0]) + size(node.children[1]) +
                size(node.children[2]) + size(node.children[3]) + 1;
        return node;
    }

    public Key query(int x, int y) {
        return query(root, x, y);
    }

    private Key query(QTNode node, int x, int y) {
        if (node == null) {
            return null;
        }
        int cmp = compare(node.x, node.y, x, y);
        if (cmp == -1) {
            return (Key) node.key;
        } else {
            return query(node.children[cmp], x, y);
        }
    }


}
