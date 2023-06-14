package Sort61B;


public class AllSortAlgorithms {
    /** The below is selectionSort part.
     *  But this method uses recursion. And which will cause extra recursive call stack spaces.
     *  And it is stable. So the time complexity is O(N^2), and the space complexity is O(N). */
    public static void selectionSort(int[] a) {
        selectionSortHelper(a, 0);
    }

    private static void selectionSortHelper(int[] a, int start) {
        if (start == a.length) {
            return;
        }
        int smallestIndex = findSmallest(a, start);
        swap(a, start, smallestIndex);
        selectionSortHelper(a, start + 1);
    }

    private static int findSmallest(int[] a, int start) {
        int smallestIndex = start;
        for (int i = start; i < a.length; i += 1) {
            if (a[i] < a[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    private static void swap(int[] a, int start, int smallestIndex) {
        int temp = a[start];
        a[start] = a[smallestIndex];
        a[smallestIndex] = temp;
    }

    /** If we use iteration for selection sort, the time complexity is still O(N^2),
     *  but the space complexity is O(1). And it is also stable. */
    public static void selectionSortIteration(int[] a) {
        for (int i = 0; i < a.length; i += 1) {
            int smallest = findSmallest(a, i);
            swap(a, i, smallest);
        }
    }


    /** The below is mergeSort part. You can also use stack and iteration for mergeSort,
     *  and maybe it is good for parallelism. But it is beyond the class's scope.
     *  For recursion implementation, the time complexity is O(NlogN), and the
     *  space complexity is O(logN). It is also stable. */
    public static void mergeSort(int[] a) {
        mergeSortHelper(a, 0, a.length - 1);
    }

    private static void mergeSortHelper(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSortHelper(a, start, middle);
        mergeSortHelper(a, middle + 1, end);
        merge(a, start, middle, end);
    }

    private static void merge(int[] a, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = middle + 1, k = 0;
        while (i <= middle && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        if (k >= 0) {
            System.arraycopy(temp, 0, a, start, k);
        }
    }

    /** The below is insertionSort part. The best time complexity is O(N), worst time
     *  complexity is O(N^2) and space complexity is O(1) because we use in-place
     *  insertion sort. It is also stable. */
    public static void insertionSort(int[] a) {
        int i, j;
        int temp;
        for (i = 1; i < a.length; i += 1) {
            j = i;
            temp = a[i];
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j -= 1;
            }
            a[j] = temp;
        }
    }
}
