public class InheritanceMisery {
    public static void main(String[] args) {
        A b0 = new B();
        System.out.println(b0.x);
        b0.m1();
        b0.m2();

        B b1 = new B();
        b1.m2(61);
        b1.m3();

        A c0 = new C();
        c0.m2();

        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();
        c2.m5();
        ((C) c0).m3();
        b0.update();
        b0.m1();
    }
}
