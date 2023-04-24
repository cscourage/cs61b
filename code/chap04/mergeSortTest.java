import org.junit.Test;
import static org.junit.Assert.*;

public class mergeSortTest {
    @Test
    public void testMergeSort() {
        int[] array = new int[]{35, 21, 50, 9, 10, 18, 1, 44};
        MergeSort.mergesort(array);
        assertArrayEquals(new int[]{1, 9, 10, 18, 21, 35, 44, 50}, array);

        int[] array1 = new int[]{5, 2, 9, 1, 5, 6};
        MergeSort.mergesort(array1);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array1);
    }
}
