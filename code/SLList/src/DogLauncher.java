import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Doge", 5);
        Dog d2 = new Dog("Grigometh", 200);
        Dog d3 = new Dog("Clifford", 9000);
        Dog[] dogs = new Dog[]{d1, d2, d3};
        Dog maxDog = (Dog) Maximizer.max(dogs);
        maxDog.bark();

        /* Test Name Comparator. */
        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(d1, d3) > 0) {
            d1.bark();
        } else {
            d3.bark();
        }

        /* Test Size Comparator. */
        Comparator<Dog> sc = Dog.getSizeComparator();
        if (sc.compare(d1, d3) > 0) {
            d1.bark();
        } else {
            d3.bark();
        }
    }
}