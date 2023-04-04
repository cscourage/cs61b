public class VengefulSLList<LochNess> extends SLList<LochNess> {
    SLList<LochNess> deleteItems;

    public VengefulSLList() {
        deleteItems = new SLList<LochNess>();
    }

    public VengefulSLList(LochNess x) {
        super(x);
        deleteItems = new SLList<>();
    }

    @Override
    public LochNess removeLast() {
        LochNess x = super.removeLast();
        deleteItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        deleteItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>(11);
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);
        vs1.removeLast();
        vs1.removeLast();
        System.out.println("The fallen are : ");
        vs1.printLostItems();
    }
}
