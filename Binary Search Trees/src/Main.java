/**
 * Testing the usage of the implemented Binary Search Tree
 */
public class Main {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        System.out.print("In-Order Traversal: ");
        intTree.traverseInOrder();

        System.out.println("\n");

//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(17));
//        System.out.println(intTree.get(8888));
//
//        System.out.println();
//
//        System.out.println(intTree.min());
//        System.out.println(intTree.max());
//
//        System.out.println();

        intTree.delete(15); // Has one child - 17
        System.out.print("In-Order Traversal: ");
        intTree.traverseInOrder();
        System.out.println("\n");

        intTree.delete(17); // Has no child
        System.out.print("In-Order Traversal: ");
        intTree.traverseInOrder();
        System.out.println("\n");

        intTree.delete(25); // Has two children
        System.out.print("In-Order Traversal: ");
        intTree.traverseInOrder();
        System.out.println("\n");

        intTree.delete(8888);
        System.out.print("In-Order Traversal: ");
        intTree.traverseInOrder();

    }
}