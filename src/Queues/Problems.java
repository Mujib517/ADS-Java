package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problems {

    public static void interleaving(Queue<Integer> q) {
        if (q.isEmpty()) return;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int count = q.size();
        int half = count / 2;

        while (half > 0) {
            q1.add(q.poll());
            half--;
        }

        while (!q.isEmpty()) q2.add(q.poll());

        while (!q1.isEmpty() && !q2.isEmpty()) System.out.print(q1.poll() + " " + q2.poll() + " ");
        while (!q2.isEmpty()) System.out.print(q2.poll() + " ");

        System.out.println();
    }

    public static Queue<Integer> reverseKElements(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> result = new LinkedList<>();

        while (!q.isEmpty() && k > 0) {
            k--;
            s.push(q.poll());
        }

        while (!s.isEmpty()) result.add(s.pop());
        while (!q.isEmpty()) result.add(q.poll());

        return result;

    }

    public static Queue<Integer> reverseKElements2(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();

        for (int i = 0; i < k; i++) {
            if (!s.isEmpty())
                s.push(q.poll());
        }

        while (!s.isEmpty()) q.add(s.pop());

        for (int i = k; i < size; i++) {
            q.add(q.poll());
        }

        return q;
    }

    //O(N*K)
    public static void slidingWindowMax(int[] arr, int k) {
        if (k > arr.length) return;

        for (int i = 0; i < arr.length - k + 1; i++) {
            System.out.print(getMin(arr, i, i + k) + " ");
        }

        System.out.println();
    }

    //O(N), O(2K) space
    public static void slidingWindowMax2(int[] arr, int k) {
        if (k > arr.length) return;

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int i = 0;

        for (; i < k; i++) insert(arr[i], q, s);
        System.out.print(s.peek() + " ");

        for (; i < arr.length; i++) {
            s.pop();
            q.poll();
            insert(arr[i], q, s);
            System.out.print(s.peek() + " ");
        }

        System.out.println();
    }

    private static void insert(int i, Queue<Integer> q, Stack<Integer> s) {
        if (q.isEmpty()) {
            q.add(i);
            s.push(i);
        } else {
            int max = Math.max(s.peek(), i);
            q.add(i);
            s.push(max);
        }
    }

    private static int getMin(int[] arr, int start, int end) {
        int max = arr[start];

        for (int i = start + 1; i < end; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}

