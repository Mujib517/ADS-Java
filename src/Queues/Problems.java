package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
}
