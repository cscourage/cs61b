public class RotatingSLList<LochNess> extends SLList<LochNess> {
    public void rotateRight() {
        LochNess x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        //wait for you to debug.
        RotatingSLList<Integer> list = new RotatingSLList<>();
        list.addLast(5);
        list.addLast(9);
        list.addLast(15);
        list.addLast(22);
        list.rotateRight();
        list.print();
    }
}
