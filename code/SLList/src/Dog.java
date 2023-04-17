import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    public int compareTo(Dog uddadog) {
        return this.size - uddadog.size;  //natural order.
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    private static class SizeComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.size - b.size;
        }
    }


    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

    public static Comparator<Dog> getSizeComparator() {
        return new SizeComparator();
    }

    /** Since there's only room for one compareTo method, if we want
     *  multiple ways to compare, we must turn to Comparator.
     */
}
