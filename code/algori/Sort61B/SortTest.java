package Sort61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class SortTest {
    /** test int array for  */
    @Test
    public void testSort1() {
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
        //AllSortAlgorithms.quickSort(a);
        AllSortAlgorithms.countingSort(a, a.length, 42);
        StringBuilder end = new StringBuilder();
        for (int j : a) {
            end.append(j).append(" ");
        }
        System.out.println(end);
    }

    @Test
    public void testSort2() {
        String[] s = {"4PGC938", "2IYE230", "3CIO720", "1ICK750",
                "1OHV845", "4JZY524", "1ICK750", "3CIO720", "1OHV845",
                "1OHV845", "2RLA629", "2RLA629", "3ATW723"};
        AllSortAlgorithms.LSDSort(s, 7);
        for (String str : s) {
            System.out.println(str);
        }
    }
}
