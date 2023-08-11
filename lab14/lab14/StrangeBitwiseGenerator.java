package lab14;

import lab14lib.Generator;

public class StrangeBitwiseGenerator implements Generator {
    private int period;
    private int state;

    public StrangeBitwiseGenerator(int period) {
        state = 0;
        this.period = period;
    }

    @Override
    public double next() {
        state = state + 1;
        int weirdState = state & (state >> 7) % period;
        return normalize(weirdState);
    }

    private double normalize(int state) {
        return  2.0 * state / (period - 1) - 1.0;
    }
}
