public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinelF;
    private StuffNode sentinelB;
    private int size;

    public LinkedListDeque() {
        sentinelF = new StuffNode(null, null, null);
        sentinelB = new StuffNode(null, null, null);
        sentinelF.next = sentinelB;
        sentinelB.prev = sentinelF;
        size = 0;
    }

    /*  the API don't need it.
    public LinkedListDeque(T item) {
        sentinelF = new StuffNode(null, null, null);
        sentinelB = new StuffNode(null, null, null);
        StuffNode tmp = new StuffNode(sentinelF, item, sentinelB);
        sentinelF.next = tmp;
        sentinelB.prev = tmp;
        size = 1;
    }
    */

    @Override
    public void addFirst(T item) {
        sentinelF.next = new StuffNode(sentinelF, item, sentinelF.next);
        sentinelF.next.next.prev = sentinelF.next;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        sentinelB.prev = new StuffNode(sentinelB.prev, item, sentinelB);
        sentinelB.prev.prev.next = sentinelB.prev;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode tmp = sentinelF.next;
        while (tmp != sentinelB) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T res = sentinelF.next.item;
        sentinelF.next = sentinelF.next.next;
        sentinelF.next.prev = sentinelF;
        size -= 1;
        return res;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T res = sentinelB.prev.item;
        sentinelB.prev = sentinelB.prev.prev;
        sentinelB.prev.next = sentinelB;
        size -= 1;
        return res;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        StuffNode tmp = sentinelF;
        int i = 0;
        while (i <= index) {
            tmp = tmp.next;
            i++;
        }
        return tmp.item;
    }

    private T getRecursiveHelper(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        StuffNode p = sentinelF.next;
        return getRecursiveHelper(p, index);
    }
}
