public class TestAnimals {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);

        a.greet();
        c.greet();
        a = c;
        ((Cat) a).greet();
        a.greet();
    }
}
