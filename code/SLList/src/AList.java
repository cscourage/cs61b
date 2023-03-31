import org.junit.matchers.JUnitMatchers;

import javax.management.ObjectName;

public class AList<Item> {
    private Item[] items;
    private int size;
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public Item removeLast() {
        Item tmp = getLast();
        items[size - 1] = null;
        size -= 1;
        return tmp;
    }
}
