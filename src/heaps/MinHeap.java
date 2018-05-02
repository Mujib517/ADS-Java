package heaps;

import java.lang.reflect.Parameter;

public class MinHeap {

    private int count = 0;
    private int[] arr;

    public MinHeap() {
        arr = new int[20];
    }

    public int size() {
        return count;
    }

    public int peek() throws Exception {
        if (count == 0) throw new Exception();
        return arr[0];
    }

    public void add(int x) {
        arr[count] = x;
        count++;
        if (count > 1)
            heapifyUp();
    }

    private void heapifyUp() {
        for (int i = count - 1; i >= 0; --i) {
            int parent = (i / 2);
            if (parent < 0) return;

            if (arr[parent] < arr[i]) continue;

            int temp = arr[parent];
            arr[parent] = arr[i];
            arr[i] = temp;
        }
    }

    public int poll() throws Exception {
        if (count == 0) throw new Exception();

        int item = arr[0];
        arr[0] = arr[count - 1];
        count--;
        if (count > 0) {

            heapifyDown();
        }
        return item;
    }

    private void heapifyDown() {
        for (int i = 0; i < count; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = left;

            if (right < count) {
                if (arr[right] < arr[left]) max = right;
            }

            if (arr[i] < arr[max]) return;

            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }
}
