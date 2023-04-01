public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> arr = new ArrayDeque<>();

        boolean passed = checkEmpty(true, arr.isEmpty());


        arr.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, arr.size()) && passed;
        passed = checkEmpty(false, arr.isEmpty()) && passed;


        arr.addLast("middle");
        passed = checkSize(2, arr.size()) && passed;

        arr.addLast("back");
        passed = checkSize(3, arr.size()) && passed;

        System.out.println("Printing out deque: ");
        arr.printDeque();

        //System.out.println("the second(index 1) item is :" + arr.getRecursive(1));
        //lld1.removeFirst();
        //lld1.printDeque();
        //lld1.removeLast();
        //lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, arr1.isEmpty());

        arr1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, arr1.isEmpty()) && passed;

        arr1.removeFirst();
        // should be empty
        passed = checkEmpty(true, arr1.isEmpty()) && passed;

        /* extra add. */
        arr1.addLast(0);
        arr1.addLast(1);
        arr1.addLast(2);
        arr1.addLast(3);
        System.out.println(arr1.get(0));

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
