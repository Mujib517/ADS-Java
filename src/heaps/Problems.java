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

        for (int i = 1; i < n; i++) {

            while (!q.isEmpty() && q.peek() <= i - k) q.removeFirst();

            while (!q.isEmpty() && arr[i] > arr[q.peek()]) q.removeFirst();
            q.addLast(i);

            //Print only when window size 3
            if (i >= k - 1)
                System.out.print(arr[q.peek()] + " ");

        }
        System.out.println();
    }

    public static void runningMedian(int[] arr, int n) {
        if (n == 0) return;

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        max.add(arr[0]);
        print(min, max);

        for (int i = 1; i < n; i++) {

            if (max.peek() > arr[i]) max.add(arr[i]);
            else min.add(arr[i]);

            balanceHeaps(min, max);
            print(min, max);
        }
    }

    private static void print(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        if (min.size() == 0) {
            System.out.print((double) max.peek() + " ");
            return;
        }

        if (min.size() == max.size()) {
            double item = ((min.peek() + max.peek()) / 2.0);
            System.out.print(item + " ");

        } else {
            System.out.print((double) min.peek() + " ");
        }
    }


    private static void balanceHeaps(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        PriorityQueue<Integer> bigger = min.size() > max.size() ? min : max;
        PriorityQueue<Integer> smaller = min.size() < max.size() ? min : max;
        if (bigger.size() - smaller.size() <= 1) return;
        smaller.add(bigger.poll());
    }
}
