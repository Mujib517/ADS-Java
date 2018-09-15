package heaps;

public class MinPriorityQ {
    //0 based index taken
    private int[] _arr;
    private int count;

    public MinPriorityQ() {
        _arr = new int[20];
        count = 0;
    }

    public void add(int val) {
        _arr[count++] = val;
        heapifyUp();
    }

    public int poll() {
        if (count == 0) throw new IllegalStateException();
        int item = _arr[0];
        _arr[0] = _arr[count - 1];
        --count;
        heapifyDown();
        return item;
    }

    public int size() {
        return this.count;
    }

    public int peek() {
        if (count == 0) throw new RuntimeException();
        return _arr[0];
    }

    private void heapifyUp() {
        int index = count - 1;
        while (hasParent(index) && getParent(index) > _arr[index]) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index))
                smallerIndex = getRightChildIndex(index);
            if (_arr[index] < _arr[smallerIndex]) break;

            swap(index, smallerIndex);
            index = smallerIndex;
        }
    }

    private void swap(int index1, int index2) {
        int temp = _arr[index1];
        _arr[index1] = _arr[index2];
        _arr[index2] = temp;
    }

    private int getParent(int index) {
        int parentIndex = getParentIndex(index);
        return _arr[parentIndex];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        //2k+1
        return (2 * index + 1) < count;
    }

    private boolean hasRightChild(int index) {
        return (2 * index + 2) < count;
    }

    private int getLeftChild(int index) {
        return _arr[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return _arr[getRightChildIndex(index)];
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
}
