/** second part of proj1a.
 * deque implemented by array
 * @author courage
 */
public class ArrayDeque<T> {
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


    /* resize longer or smaller and we put the "front" in the location of "newarray" index 0*/
    private void resize(int newlength) {
        T[] newarray = (T[]) new Object[newlength];
        int ptr1 = front;
        int ptr2 = 0;
        while (ptr1 != last) {
            newarray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, newlength);
        }
        array = newarray;
        length = newlength;
        front = 0;
        last = ptr2;
    }

    /** notice we set the "grow" condition with "size == length - 1"
     *  in order to pretend the situation that the last equals to the front
     *  and int that situation we can't access to the while loop in method grow.
    */
    public void addFirst(T item) {
        if (size == length - 1) {
            resize(length * 2);
        }
        front = minusOne(front);
        array[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            resize(length * 2);
        }
        array[last] = item;
        last = plusOne(last, length);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int ptr = front;
        while (ptr != last) {
            System.out.print(array[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T tmp = array[front];
        // avoid loitering.
        array[front] = null;
        front = plusOne(front, length);
        size--;
        if (length >= 16 && length / size >= 4) {
            resize(length / 2);
        }
        return tmp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        last = minusOne(last);
        T tmp = array[last];
        //avoid loitering.
        array[last] = null;
        size--;
        if (length >= 16 && length / size >= 4) {
            resize(length / 2);
        }
        return tmp;
    }

    /* notice that get method should take constant time. */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[(front + index) % length];
    }
}
