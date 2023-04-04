public class SLList<LochNess> {
    private class StuffNode {
        public LochNess item;
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }
    private StuffNode sentinel;
    private int size;
    private StuffNode last;

    public SLList() {
        sentinel = new StuffNode(null, null);
        last = sentinel;
        size = 0;
    }

    public SLList(LochNess x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        last = sentinel.next;
        size = 1;
    }

    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
        /* special case */
        if (last == sentinel) {
            last = sentinel.next;
        }
    }

    public void addLast(LochNess x) {
        last.next = new StuffNode(x, null);
        last = last.next;
        size += 1;
    }

    public LochNess getFirst() {
        return sentinel.next.item;
    }

    public LochNess getLast() {
        return last.item;
    }

    public int size() {
        return size;
    }

    public LochNess removeLast() {
        StuffNode p = sentinel;
        LochNess result = last.item;
        // special cases including size = 0
        if (size == 0) {
            return null;
        }
        while (p.next != last) {
            p = p.next;
        }
        last = p;
        p.next = null;
        size--;
        return result;
    }

    public void print() {
        StuffNode p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /*
     1.in order to remove the special case of addFirst for last pointer,
       we can add a final sentinel just like previous first;
     2.but after it, we can see that the method getLast and addLast will be tricky;
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
