package BST61B;

public class BST<Key> {
    private Key key;
    private BST left;
    private BST right;

    public BST(Key key, BST left, BST right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(Key key) {
        this.key = key;
    }

    public BST find(BST T, Key sk) {
        if (T == null) {
            return null;
        }
        if (sk.equals(T.key)) {
            return T;
        } else if (sk < T.key) {
            return find(T.left, key);
        } else {
            return find(T.right, key);
        }
    }

    public BST insert(BST T, Key ik) {
        if (T == null) {
            return new BST(ik);
        }
        if (ik < T.key) {
            T.left = insert(T.left, ik);
        } else if (ik > T.key) {
            T.right = insert(T.right, ik);
        }
        return T;
    }


}
