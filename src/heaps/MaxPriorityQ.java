package heaps;

public class MaxPriorityQ {
    private int[] arr = new int[20];
    private int count = 0;

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
        count--;
        heapifyDown();
        return item;

    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index))
                largerIndex = getRightChildIndex(index);

            if (arr[largerIndex] < arr[index]) break;
            swap(largerIndex, index);
            index = largerIndex;
        }
    }

    private int getLeftChild(int index) {
        return arr[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
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
        int parentIndex = getParentIndex(index);
        while (hasParent(index) && arr[parentIndex] < arr[index]) {
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void swap(int parentIndex, int index) {
        int temp = arr[index];
        arr[index] = arr[parentIndex];
        arr[parentIndex] = temp;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
}
