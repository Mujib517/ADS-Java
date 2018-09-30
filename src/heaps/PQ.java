package heaps;

import graph.Edge;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

//Min heap for graph
//Add, poll, peek and decrease,contains operations supported
public class PQ {

    private int count;
    private Edge[] arr;
    private Map<Integer, Integer> map;

    public PQ(int size) {
        arr = new Edge[size];
        count = 0;
        map = new HashMap<>();
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Edge peek() {
        if (count == 0) throw new IllegalStateException();
        return arr[0];
    }

    public void add(Edge item) {
        arr[count++] = item;
        if (!map.containsKey(item)) map.put(item.id, count - 1);
        heapifyUp();
    }

    public Edge poll() {
        if (count == 0) throw new IllegalStateException();

        Edge item = arr[0];
        arr[0] = arr[--count];
        map.remove(item);
        heapifyDown();
        return item;
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }

    public void decrease(int item, int weight) {
        int index = map.get(item);
        Edge edge = arr[index];
        if ((weight >= edge.weight)) return;

        while (hasParent(index) && getParent(index).compareTo(arr[index]) > 0) {
            int parent = getParentIndex(index);
            swap(parent, index);
            modifyIndexPosition(arr[index], index);
            modifyIndexPosition(arr[parent], parent);
            index = parent;
        }
    }

    private Edge getParent(int index) {
        return arr[getParentIndex(index)];
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int lowerIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);

            if (hasRightChild(index) && arr[rightIndex].compareTo(arr[lowerIndex]) < 0)
                lowerIndex = rightIndex;

            if (arr[index].compareTo(arr[lowerIndex]) <= 0) return;

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
            if (arr[parent].compareTo(arr[index]) <= 0) return;
            swap(parent, index);
            modifyIndexPosition(arr[index], index);
            modifyIndexPosition(arr[parent], parent);
            index = parent;
        }
    }

    private void modifyIndexPosition(Edge item, int newIndex) {
        if (map.containsKey(item.id)) {
            map.remove(item);
            map.put(item.id, newIndex);
        }
    }

    private void swap(int parent, int index) {
        Edge temp = arr[parent];
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
