public class Combine {
    public static int combine(ComFunc f, int[] x) {
        if (x.length == 0) {
            return 0;
        }
        if (x.length == 1) {
            return x[0];
        }
        return combineHelper(f, x, 0);
    }

    private static int combineHelper(ComFunc f, int[] x, int index) {
        if (index == x.length - 1) {
            return x[x.length - 1];
        }
        return f.apply(x[index], combineHelper(f, x, index + 1));
    }

    public static void main(String[] args) {
        int[] x = new int[]{10, 20, 30, 40, 50, 60};
        ComFunc f = new Add();
        int result = combine(f, x);
        System.out.println(result);
    }
}
