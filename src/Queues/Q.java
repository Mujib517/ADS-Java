package Queues;

public class Q {
    private int[] data = new int[5];
    private int count = 0;
    public int first = -1;
    public int last = -1;


    public boolean isEmpty() {
        return count == 0;
    }

    public void enQueue(int val) throws Exception {
        if (count == data.length) throw new Exception("Queue is full");
        if (count < data.length)
            data[count++] = val;
        if (count == 1) first = 0;
        last++;
    }

    public int deQueue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty");
        count--;
        int elem = data[first];
        if (count == 0) first = -1;
        else first++;
        return elem;
    }


    public int top() throws Exception {
        if (isEmpty()) throw new Exception("Empty Queue");
        return data[first];
    }
}
