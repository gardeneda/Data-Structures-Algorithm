import java.util.Iterator;
import java.util.LinkedList;

public class main {

    public static void main(String[] args) {

//      Demonstration of the Singly Linked List
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        EmployeeLinkedList list = new EmployeeLinkedList();

//        System.out.println(list.isEmpty());
//
//        list.addToFront(janeJones);
//        list.addToFront(johnDoe);
//        list.addToFront(marySmith);
//        list.addToFront(mikeWilson);
//
//        System.out.println(list.getSize());
//
//        list.printList();
//
//        list.removeFromFront();
//        System.out.println(list.getSize());
//
//        list.printList();

//        ##################################################

//      Demonstration of the Doubly Linked List
        EmployeeDoublyLinkedList list2 = new EmployeeDoublyLinkedList();

        list2.addToFront(janeJones);
        list2.addToFront(johnDoe);
        list2.addToFront(marySmith);
        list2.addToFront(mikeWilson);

//        list2.printList();
//        System.out.println(list2.getSize());
//
//        list2.addToTail(billEnd);
//        list2.printList();
//        System.out.println(list2.getSize());
//        list2.removeFromFront();
//        list2.printList();
//        System.out.println(list2.getSize());
//        list2.removeFromTail();
//        list2.printList();
//        System.out.println(list2.getSize());


        LinkedList<Employee> listJDK = new LinkedList<>();
        listJDK.addFirst(janeJones);
        listJDK.addFirst(johnDoe);
        listJDK.addFirst(marySmith);
        listJDK.addFirst(mikeWilson);

        Iterator iter = listJDK.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");

        //        Alternate Code Form of the Above
//        for (Employee employee : listJDK) {
//            System.out.println(employee);
//        }

        // the add() adds the item to the tail.
        listJDK.add(billEnd);
        iter = listJDK.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");

        listJDK.removeFirst();
        iter = listJDK.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");

        listJDK.removeLast();
        iter = listJDK.iterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");


    }
}
