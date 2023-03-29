public class SLListLauncher {
    public static void main(String[] args) {
        SLList<String> s1 = new SLList<>("hello");
        s1.addLast("world");
        System.out.println("first: " + s1.getFirst());
        System.out.println("last: " + s1.getLast());
        System.out.println("size: " + s1.size());
    }
}
