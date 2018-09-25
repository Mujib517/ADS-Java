package heaps;

import java.util.HashMap;
import java.util.Map;

//Min heap for graph
//Add, poll, peek and decrease,contains operations supported
public class MinPQ {

    private int count;
    private int[] arr;
    private Map<Integer, Integer> map;

    public MinPQ(int size) {
        arr = new int[size];
        count = 0;
        map = new HashMap<>();
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        if (count == 0) throw new IllegalStateException();
        return arr[0];
    }

    public void add(int item) {
        arr[count++] = item;
        if (!map.containsKey(item)) map.put(item, count - 1);
        heapifyUp();
    }

    public int poll() {
        if (count == 0) throw new IllegalStateException();

        int item = arr[0];
        arr[0] = arr[--count];
        map.remove(item);
        heapifyDown();
        return item;
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int lowerIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);

            if (hasRightChild(index) && arr[rightIndex] < arr[lowerIndex])
                lowerIndex = rightIndex;

            if (arr[index] <= arr[lowerIndex]) return;

            swap(index, lowerIndex);
            modifyIndexPosition(arr[index], index);
            modifyIndexPosition(arr[lowerIndex], lowerIndex);
            index = lowerIndex;
        }
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < count;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < count;
    }

    private void heapifyUp() {
        int index = count - 1;
        while (hasParent(index)) {
            int parent = getParentIndex(index);
            if (arr[parent] <= arr[index]) return;
            swap(parent, index);
            modifyIndexPosition(arr[index], index);
            modifyIndexPosition(arr[parent], parent);
            index = parent;
        }
    }

    private void modifyIndexPosition(int item, int newIndex) {
        if (map.containsKey(item)) {
            map.remove(item);
            map.put(item, newIndex);
        }
    }

    private void swap(int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
}
