package Sort61B;

import java.util.Random;


/** Notice: we use the big O representation for tight bounds. */

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

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
     *  space complexity is O(N). It is also stable. */
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

    /** The below is shellSort part. It may be unstable. The space complexity is O(1).
     *  The best time complexity is O(N), worst time complexity is omega(NlogN) and O(?)
     *  depends on the sequence you choose. The sequence we choose here is using the
     *  princeton's example 1/2*(3^k-1). It is good enough for normal conditions. */
    public static void shellSort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i += 1) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    /** The below is quickSort part. We shuffle the array, pick the leftmost item as pivot, and
     *  use Tony Hoare's partitioning(not the same, just the liked method, which is inspired by my
     *  school's data structure class) to avoid the worst case and accelerate the method. Its time
     *  complexity is O(NlogN) in average and has only little probability in O(N^2) and space
     *  complexity is O(logN) for extra recursive stacks. It is unstable because the shuffling
     *  and partitioning strategy. */
    public static void quickSort(int[] a) {
        shuffle(a);
        quickSortHelper(a, 0, a.length - 1);
    }

    private static void quickSortHelper(int[] a, int low, int high) {
        int i = low, j = high;

        if (low >= high) {
            return;
        }

        int pivot = a[i];
        /* while the tow pointer don't encounter, just get into loop. */
        while (i < j) {
            /* from j to i until find an item less than or equal to pivot.*/
            while (i < j && pivot < a[j]) {
                j -= 1;
            }
            /* replace and update i to add 1. */
            if (i < j) {
                a[i] = a[j];
                i += 1;
            }
            /* then from i to j until find an item larger than pivot. */
            while (i < j && a[i] <= pivot) {
                i += 1;
            }
            /* replace and update j to minus 1. */
            if (i < j) {
                a[j] = a[i];
                j -= 1;
            }
        }
        a[i] = pivot;
        quickSortHelper(a, low, j - 1);
        quickSortHelper(a, i + 1, high);
    }

    /** I ask the chatGPT and he tells me the Fisher–Yates shuffling, i.e. Knuth shuffling. */
    private static void shuffle(int[] a) {
        Random rand = new Random();
        for (int i = a.length - 1; i >= 0; i -= 1) {
            int j = rand.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /** The below is counting sort. Its time complexity is O(N+R) and space complexity is also
     * O(N+R). Notice that N is the key size and R is the alphabet size. If N >= R, then we
     * expected a reasonable performance. But it has some restriction that no obvious way to
     * sort hard-to-count things like Strings. And it is stable. */
    public static void countingSort(int[] a, int N, int R) {
        // create and initialize the counts.
        int[] counts = new int[R];
        for (int element : a) {
            counts[element] += 1;
        }
        // create and initialize the starting points.
        int[] startingPoint = new int[R];
        int temp = 0, i = 0;
        for (int element : counts) {
            startingPoint[i] = temp;
            temp += element;
            i += 1;
        }
        // N times: check and update target position.
        int[] sorted = new int[N];
        for (int element : a) {
            sorted[startingPoint[element]] = element;
            startingPoint[element] += 1;
        }
        // copy back.
        System.arraycopy(sorted, 0, a, 0, N);
    }

    /** LSD. copied and revised by princeton. */
    public static void LSDSort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            // create and initialize the counts.
            int[] count = new int[R + 1];
            for (String s : a) {
                count[s.charAt(d) + 1] += 1;
            }
            // transform counts to indices.
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            // Distribute.
            for (String s : a) {
                aux[count[s.charAt(d)]++] = s;
            }
            // copy back.
            System.arraycopy(aux, 0, a, 0, N);
        }
    }
}
