public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size; // Is 0 from default.


    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (head == null) {
            tail = node;
        }
        else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }


    public void addToTail(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        // Checks if the node is the only one in the list.
        if (head.getNext() == null) {
            tail = null;
        }
        else {
            head.getNext().setPrevious(null);

        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }


    public EmployeeNode removeFromTail() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        // Checks if the node is the only one in the list.
        if (tail.getPrevious() == null) {
            head = null;
            tail = null;
        }
        else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }


    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD ->");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
