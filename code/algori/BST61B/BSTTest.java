package BST61B;

import static org.junit.Assert.*;
import org.junit.Test;

public class BSTTest {
    @Test
    public void testBST() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(9);
        bst.insert(1);
        bst.insert(5);
        bst.insert(6);
        assertTrue(bst.search(2));
        assertFalse(bst.search(8));
        bst.delete(5);
        assertFalse(bst.search(5));
    }
}
