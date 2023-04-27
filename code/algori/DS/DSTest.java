package DS;

import org.junit.Test;
import static org.junit.Assert.*;

public class DSTest {
    @Test
    public void test() {
        DisjointSets ds = new WeightQuickUnionWithPathCompressionDS(9);
        //DisjointSets ds = new QuickFindDS(9)
        ds.connect(3, 4);
        ds.connect(3, 5);
        ds.connect(0, 1);
        ds.connect(0, 2);
        ds.connect(0, 3);
        ds.isConnected(0,4);

        ds.connect(6, 7);
        ds.connect(6, 8);
        assertFalse(ds.isConnected(0, 6));

        ds.connect(0, 8);
        assertTrue(ds.isConnected(0, 6));
    }
}
