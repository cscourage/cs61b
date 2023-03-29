public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    private IntNode last;

    public SLList() {
        sentinel = new IntNode(63, null);
        last = sentinel;
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        last = sentinel.next;
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
        /* special case */
        if (sentinel.next.next == null) {
            last = sentinel.next;
        }
    }

    public void addLast(int x) {
        last.next = new IntNode(x, null);
        last = last.next;
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public int getLast() {
        return last.item;
    }

    public int size() {
        return size;
    }

    /*
     1.in order to remove the special case of addFirst for last pointer,
       we can add a final sentinel just like previous first;
     2.but after it, we can see that the method getLast will be tricky;
     3.so it introduce the topic of DLList.
     */

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println("first: " + L.getFirst());
        System.out.println("last: " + L.getLast());
        System.out.println("size: " + L.size());
    }
}
