import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.delete(0);
        heap.printHeap();

        System.out.println(heap.peek());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(25);
        pq.add(-22);
        pq.add(54);
        pq.add(1343);
        pq.add(0);
        pq.add(-5522);
        pq.add(622);

//        System.out.println(pq.peek());
//        System.out.println(pq.remove());
//        System.out.println(pq.peek());
//        System.out.println(pq.poll());
//        System.out.println(pq.peek());
//        System.out.println(pq.remove(75));


        System.out.println("\nConverting to Array:");
        Object[] ints = pq.toArray();
        for (Object num : ints) {
            System.out.println(num);
        }
//        System.out.println(pq.peek());
        pq.add(-1);
//        System.out.println(pq.peek());

        pq.remove();
        System.out.println();

    }
}
