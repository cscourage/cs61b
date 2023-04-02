public class Sort {
    /* Sorts the strings destructively. */
    public static void sort(String[] x) {
        // find the smallest item
        // swap it with front
        // selection sort the remaining (using recursion?)
        sort(x, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return ;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /** returns index of the smallest string in x.
     * @ source Got help with string compares from https://goo.gl/a7yBU5.
     */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /** swap item a with b. */
    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
