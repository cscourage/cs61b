package SpatialTree;

public class QTNode<Key> {
    private static final int MAX_CHILDREN = 4;
    public Key key;
    public int x;
    public int y;
    public int size;
    public QTNode[] children;

    public QTNode(Key key, int x, int y, int size) {
        this.key = key;
        this.x = x;
        this.y = y;
        this.size = size;
        children = new QTNode[4];
    }
}
