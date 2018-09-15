package heaps;

import java.util.Comparator;

public class PriorityQ {
    private int[] arr;
    private int count;
    private Comparator comparator;

    public PriorityQ() {
        arr = new int[20];
        count = 0;
        this.comparator = Comparator.naturalOrder();
    }

    public PriorityQ(Comparator comparator) {
        this.comparator = comparator;
        arr = new int[20];
        count = 0;
    }

    public int size() {
        return count;
    }

    public int peek() {
        if (count == 0) throw new IllegalStateException();
        return arr[0];
    }

    public void add(int item) {
        arr[count++] = item;
        heapifyUp();
    }

    public int poll() {
        if (count == 0) throw new IllegalStateException();
        int item = arr[0];
        arr[0] = arr[count - 1];
        --count;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int swapIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && comparator.compare(rightChild(index), leftChild(index)) < 0)
                swapIndex = getRightChildIndex(index);

            if (comparator.compare(arr[index], arr[swapIndex]) < 0) break;

            swap(index, swapIndex);
            index = swapIndex;
        }
    }

    private int leftChild(int index) {
        return arr[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return arr[getRightChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < count;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < count;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index + 1);
    }

    private int getRightChildIndex(int index) {
        return (2 * index + 2);
    }

    private void heapifyUp() {
        int index = count - 1;
        //parent(index) > arr[index]
        while (hasParent(index) && comparator.compare(parent(index), arr[index]) > 0) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void swap(int parentIndex, int index) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[index];
        arr[index] = temp;
    }

    private int parent(int index) {
        return arr[getParentIndex(index)];
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
}
