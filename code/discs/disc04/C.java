public class C extends B {
    public int y = x + 1;

    public void m2() {
        System.out.println("Cm2-> " + super.x);
    }

    public void m5() {
        System.out.println("Cm5-> " + y);
    }
}
