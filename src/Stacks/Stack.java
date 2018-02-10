package Stacks;

public class Stack {
    private int[] _arr = new int[1000];
    private int top = -1;

    public void push(int val) {
        //top++;
        _arr[++top] = val;
    }

    public int pop() {
        if(top==-1) throw new IllegalArgumentException();
        return _arr[top--];
    }

    public int peek() {
        if(top==-1) throw new IllegalArgumentException();
        return _arr[top];
    }

    public int count() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
