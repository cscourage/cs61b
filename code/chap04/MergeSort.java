public class MergeSort {
    public static void mergesort(int[] arr) {
        mergesortHelper(arr, 0, arr.length - 1);
    }

    private static void mergesortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergesortHelper(arr, start, middle);
        mergesortHelper(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= middle) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }
        for (int m = 0; m < k; m += 1) {
            arr[start + m] = tmp[m];
        }
    }
}
