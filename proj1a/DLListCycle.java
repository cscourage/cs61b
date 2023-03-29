public class DLListCycle<T> {
    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public DLListCycle() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public DLListCycle(T item) {
        sentinel = new StuffNode(null, null, null);
        StuffNode tmp = new StuffNode(sentinel, item, sentinel);
        sentinel.prev = tmp;
        sentinel.next = tmp;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new StuffNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode tmp = sentinel.next;
        while (tmp != sentinel) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return res;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        StuffNode tmp = sentinel;
        int i = 0;
        while (i <= index) {
            tmp = tmp.next;
            i++;
        }
        return tmp.item;
    }

    public T getRecursiveHelper(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        StuffNode p = sentinel.next;
        return getRecursiveHelper(p, index);
    }
}
