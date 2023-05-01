package BST61B;

public class BST {
    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }

        public TreeNode(int key, TreeNode left, TreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        /* Base Case. */
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.key) {
            node.left = insert(node.left, val);
        } else if (val > node.key) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.key == val) {
            return true;
        } else if (node.key > val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.key == val) {
            /* if and else if is for no children or one child,
            *  else is for two children by using successor,
            *  "Hibbard deletion".
            */
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode successor = findSuccessor(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);
            }
        } else if (node.key > val) {
            node.left = delete(node.left, val);
        } else {
            node.right = delete(node.right, val);
        }
        return node;
    }

    private TreeNode findSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}