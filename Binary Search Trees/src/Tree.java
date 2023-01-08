public class Tree {

    /**
     * A Binary Search Tree that only takes integer values.
     *
     * @see TreeNode
     */
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    /**
     * The main delete function
     * @param value the integer value we want to delete from the Binary Search Tree
     * @see #delete(TreeNode subtreeRoot, int value)
     */


    public void delete(int value) {
        root = delete(root, value);
    }

    /**
     * The proprietary method to help the main delete function
     * We pass the subtree's Root because we don't know which direction to go in yet.
     * @param subtreeRoot the original root value
     * @param value the integer value we want to remove from the Binary Search Tree
     */
    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return null;
        }

        // If the value is less than the root of the subtree we're searching,
        // we're moving to the subtree's left child. Then we replace the left child's value
        // with the result of delete().
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        // This is executed when we find the value we want to delete.
        else {
            // Cases 1 and 2: node to delete has 0 or 1 children
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            }
            else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }

        return subtreeRoot;
     }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }
}
