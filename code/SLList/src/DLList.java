public class DLList {
    private static class IntNode {
        public IntNode prev;
        public int item;
        public IntNode next;

        public IntNode(IntNode p, int i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    public DLList(int x) {
        sentinel = new IntNode(null, 63, null);
        sentinel.next = new IntNode(sentinel, x, null);
        last = sentinel.next;
        size = 1;
    }

    public DLList() {
        sentinel = new IntNode(null, 63, null);
        last = sentinel;
        size = 0;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        last.next = new IntNode(last, x, null);
        last = last.next;
        size += 1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        //SLList L = new SLList(15);
        //L.addFirst(10);
        //L.addFirst(5);
        //L.addLast(20);
        DLList L = new DLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println("first: " + L.getFirst());
        System.out.println("size: " + L.size());
    }
}