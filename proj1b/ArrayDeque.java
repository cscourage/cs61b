/** second part of proj1a.
 * deque implemented by array
 * @author courage
 */
public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int size;
    private int length;
    private int front;
    private int last;
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 0;
        last = 0;
    }

    private int minusOne(int index) {
        return ((index + length - 1) % length);
    }

    private int plusOne(int index, int modul) {
        return (index + 1) % modul;
    }

    /* resize larger and we put the "front" in the location of "newarray" index 0. */
    private void grow() {
        T[] newarray = (T[]) new Object[length * 2];
        int ptr1 = front;
        int ptr2 = 0;
        //notice the last don't indicate a T element.
        while (ptr1 != last) {
            newarray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length * 2);
        }
        front = 0;
        last = ptr2;
        array = newarray;
        length *= 2;
    }

    /* resize smaller and we put the "front" in the location of "newarray" index 0*/
    private void shrink() {
        T[] newarray = (T[]) new Object[length / 2];
        int ptr1 = front;
        int ptr2 = 0;
        while (ptr1 != last) {
            newarray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        front = 0;
        last = ptr2;
        array = newarray;
        length /= 2;
    }

    /** notice we set the "grow" condition with "size == length - 1"
     *  in order to pretend the situation that the last equals to the front
     *  and int that situation we can't access to the while loop in method grow.
    */
    @Override
    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        front = minusOne(front);
        array[front] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        array[last] = item;
        last = plusOne(last, length);
        size++;
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
        int ptr = front;
        while (ptr != last) {
            System.out.print(array[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        T tmp = array[front];
        front = plusOne(front, length);
        size--;
        return tmp;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        last = minusOne(last);
        T tmp = array[last];
        size--;
        return tmp;
    }

    /* notice that get method should take constant time. */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[(front + index) % length];
    }
}
