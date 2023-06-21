package Sort61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class SortTest {
    @Test
    public void testSort() {
        int[] a = {32, 15, 2, 17, 19, 26, 41, 17, 17};
        StringBuilder origin = new StringBuilder();
        for (int j : a) {
            origin.append(j).append(" ");
        }
        System.out.println(origin);
        //AllSortAlgorithms.selectionSort(a);
        //AllSortAlgorithms.selectionSortIteration(a);
        //AllSortAlgorithms.mergeSort(a);
        //AllSortAlgorithms.insertionSort(a);
        //AllSortAlgorithms.shellSort(a);
        AllSortAlgorithms.quickSort(a);
        StringBuilder end = new StringBuilder();
        for (int j : a) {
            end.append(j).append(" ");
        }
        System.out.println(end);
    }
}
