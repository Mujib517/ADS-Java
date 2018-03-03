package Queues;

import java.util.ArrayList;
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
}
