public class BinarySearch {
    public static int binary(String[] sorts, String x, int lo, int hi) {
        if (lo > hi) return -1;
        int middle = (lo + hi) / 2;
        int cmp = x.compareTo(sorts[middle]);
        if (cmp > 0) return binary(sorts, x, middle + 1, hi);
        else if (cmp < 0) return binary(sorts, x, lo, middle - 1);
        else return middle;
    }

    public static int binaryIterative(String[] sorts, String x, int lo, int hi) {
        while (lo <= hi) {
            int middle = (lo + hi) / 2;
            int cmp = x.compareTo(sorts[middle]);
            if (cmp > 0) lo = middle + 1;
            else if (cmp < 0) hi = middle - 1;
            else return middle;
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] sorted = {"ao", "be", "cow", "demo", "egg", "fetch"};
        String x = "egg";
        int put = binary(sorted, x, 0, 5);
        int pu = binaryIterative(sorted, x, 0, 5);
        System.out.println(put);
        System.out.println(pu);
    }
}
