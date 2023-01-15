/**
 * The Heap class is a Max-Heap implemented by an array.
 * The size of the array is fixed, and the array will not re-size to
 * allow more values to be put in.
 */
public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];

    }

    /**
     * Insert a value into a Heap implemented with an array.
     * Will throw if the index is out of bounds.
     *
     * @param value the integer value that will be inserted into the heap.
     */
    public void insert(int value) throws IndexOutOfBoundsException {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        heapifyAbove(size);
        size++;
    }

    // return the value we deleted

    /**
     * Though the standard delete function for Heaps do not require any parameters as they just remove the root,
     * this implementation will support deleting any element in the heap. Deletes the original value,
     * replaces it with the right-most value, and then fix the heap with {@link #heapifyAbove(int)}
     * if value is greater than parent, or {@link #heapifyBelow(int)}if the value is less than the parent.
     *
     * @param index the index of the node to delete.
     * @return the integer value that is being deleted.
     * @see #heapifyAbove(int)
     * @see #heapifyBelow(int)
     */
    public int delete(int index) throws IndexOutOfBoundsException{
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size-1];

        // Node deleted was root or if the replacement value is less than the parent.
        if (index == 0 || heap[index] < heap[parent]) {
            heapifyBelow(index);
        }
        else {
            heapifyAbove(index);
        }

        size--;

        return deletedValue;
    }

    /**
     * Because this is a Max-Heap interpretation, the peek value - which often returns the root node value,
     * will return the maximum value in the heap.
     *
     * @return the largest integer value in the entire heap.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    /**
     * Replace the values whenever the value being added or deleted have to replace their parents
     * because their value is greater than their parents, so that we can maintain the complete binary tree property.
     *
     * @param index the index value of the initial insert/delete
     */
    private void heapifyAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    /**
     * A {@link #heapifyBelow(int)} function that has an additional parameter
     * for use when using the HeapSort algorithm.
     *
     * @param index the index of the starting position
     * @param lastHeapIndex the last index position of the heap
     */
    private void heapifyBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild= getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                // If this condition succeeds, this node does not have a right child.
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                }
                else {
                    childToSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else {
                    break;
                }
                index = childToSwap;
            }
            else {
                break;
            }
        }
    }

    /**
     * A function that fixes the implemented array to allow it to retain its heap property.
     * Used to replace the node with the child that has the greatest value.
     * For example, if left child is greater than the node's value and the right child,
     * then the left child will take the position of the node, and the node's value will move
     * to the left child's position.
     * <p></p>
     * There is an alternate version of the function for use in the HeapSort algorithm.
     * {@link #heapifyBelow(int, int)}
     * <p></p>
     *
     * @param index the index of the starting position or node.
     */
    private void heapifyBelow(int index) {
        int childToSwap;

        while (index <= size - 1) {
            int leftChild= getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= size - 1) {
                // If this condition succeeds, this node does not have a right child.
                if (rightChild > size - 1) {
                    childToSwap = leftChild;
                }
                else {
                    childToSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else {
                    break;
                }
                index = childToSwap;
            }
            else {
                break;
            }
        }
    }

    public boolean isFull() {
        return size == heap.length;
    }

    // Type casting automatically done in integer division
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Returns the left OR the right child.
     * Both children cannot be returned in one instance.
     * Can potentially throw an {@link IndexOutOfBoundsException} if
     * the child does not exist, and so should be wrapped in a conditional or a try-catch.
     *
     * @param index the index of the node that the child must be retrieved from.
     * @param left True if left child of the node needs to be retrieved.
     *             If false, the right child of the node is retrieved
     * @return the index value of the child.
     */
    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

}

