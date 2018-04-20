package heaps;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problems {

    // O((N-K) K LogK)
    public static void slidingWindowMax(int[] arr, int n, int k) {

        for (int i = 0; i < n - k + 1; i++) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
            //KLogK
            for (int j = i; j < i + k; j++) {
                heap.add(arr[j]);
            }

            System.out.print(heap.peek() + " ");
        }

        System.out.println();
    }

    public static void slidingWindowMax2(int[] arr, int n, int k) {
        if (arr.length == 0) return;

        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);

        for (int i=1; i < n; i++) {

            while (!q.isEmpty() && q.peek() <= i - k) q.removeFirst();

            while (!q.isEmpty() && arr[i] > arr[q.peek()]) q.removeFirst();
            q.addLast(i);

            //Print only when window size 3
            if (i >= k-1)
                System.out.print(arr[q.peek()] + " ");

        }
        System.out.println();
    }
}
