import java.util.Arrays;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        int longest = 0;
        String[] retSorted = new String[asciis.length];
        for (int i = 0; i < asciis.length; i += 1) {
            String temp = asciis[i];
            retSorted[i] = temp;
            longest = temp.length() > longest ? temp.length() : longest;
        }
        for (int i = longest - 1; i >= 0; i -= 1) {
            sortHelperLSD(retSorted, i);
        }
        return retSorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] counts = new int[257];
        for (String s : asciis) {
            if (s.length() <= index) {
                counts[0]++;
            } else {
                counts[(int) s.charAt(index) + 1]++;
            }
        }

        int[] starts = new int[257];
        int temp = 0, k = 0;
        for (int count : counts) {
            starts[k++] = temp;
            temp += count;
        }

        String[] sorted = new String[asciis.length];
        for (String item : asciis) {
            int id = item.length() <= index ? 0 : (int) item.charAt(index) + 1;
            int place = starts[id];
            sorted[place] = item;
            starts[id] += 1;
        }

        for (int i = 0; i < asciis.length; i += 1) {
            asciis[i] = sorted[i];
        }

    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }

    public static void main(String[] args) {
        String[] myTest = {"balala", "alisa", "oh"};
        String[] sorted = sort(myTest);
        System.out.println(Arrays.toString(sorted));
    }
}
