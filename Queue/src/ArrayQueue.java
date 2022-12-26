import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    // Front field never changes becasue we're always adding to the back

    public void add(Employee employee) {
        // Check if the queue is full.
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];

            // Copies from front to the end of the array. (Ex. Index 3~5)
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            // Copies the rest of the array (Ex. Index 0~2) #IF following the example above.
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            queue = newArray;

            front = 0;
            // size() is dependent on back, but back is still the previous value.
            back = numItems;
        }


        // 0 - jane
        // 1 - john
        // 2 -      - back
        // 3 - mike - front
        // 4 - bill

        // Resize -->
        // 0 - mike
        // 1 - bill
        // 2 - jane
        // 3 - john
        // 4        - back

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        }
        else {
            back = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        else if (front == queue.length) {
            front = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        }
        else {
            return back - front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else {
            // Prints Front to end of array if wrapped
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            // Prints the rest of the array
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
