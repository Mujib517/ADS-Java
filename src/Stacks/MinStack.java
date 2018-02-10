package Stacks;

public class MinStack {
    Item[] arr = new Item[1000];
    int top = -1;

    public void push(int val) {
        int min;
        if (top == -1) min = val;
        else {
            Item topItem = this.peek();
            min = Math.min(topItem.min, val);
        }

        Item item = new Item(val, min);
        arr[++top] = item;
    }

    public Item pop() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException();
        return arr[top--];
    }

    public Item peek() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException();
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getMin() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException();
        return arr[top].min;
    }

}
