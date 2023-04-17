public class DLList {
    /* 1. Rebranding. */
    /* 4.Nested Classes. */
    private static class IntNode {
        /* 7.Looking Back. */
        public IntNode prev;
        public int item;
        public IntNode next;

        public IntNode(IntNode p, int i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* 2. Bureaucracy. */
    /* 3.Public vs. Private. */
    private IntNode sentinel;
    private IntNode last;
    /* 5.Caching. */
    private int size;

    /* 6.The empty list. */
    public DLList() {
        sentinel = new IntNode(null, 63, null);
        last = sentinel;
        size = 0;
    }

    public DLList(int x) {
        sentinel = new IntNode(null, 63, null);
        sentinel.next = new IntNode(sentinel, x, null);
        last = sentinel.next;
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        // special case
        if (size != 0) {
            sentinel.next.next.prev = sentinel.next;
        }
        // special case.
        if (size == 0) {
            last = sentinel.next;
        }
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    /* 6b.sentinel node for avoiding special case. */
    public void addLast(int x) {
        last.next = new IntNode(last, x, null);
        last = last.next;
        size += 1;
    }

    /**
    private int sizeHelper(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + sizeHelper(p.next);
    }

    public int size() {
        return sizeHelper(first);
    }
     */
    public int size() {
        return size;
    }

    public int getLast() {
        return last.item;
    }



    public static void main(String[] args) {
        DLList L = new DLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
    }
}