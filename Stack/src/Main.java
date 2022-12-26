public class Main {

    public static void main(String[] args) {

//        ArrayStack stack = new ArrayStack(10);
        LinkedStack stack = new LinkedStack();

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith= new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

        stack.printStack();

        System.out.println(stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println(stack.peek());

    }
}
