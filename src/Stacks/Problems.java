package Stacks;

import java.util.Stack;

public class Problems {

    //O(N),O(N)
    public static boolean hasBalancedParenthesis(String str) {
        Stack<Character> s = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {

                case '{':
                case '[':
                case '(':
                    s.push(str.charAt(i));
                    break;

                case '}':
                case ']':
                case ')':
                    if (s.isEmpty()) return false;
                    char top = s.pop();
                    char c = str.charAt(i);
                    if (top == '(' && c != ')') return false;
                    if (top == '[' && c != ']') return false;
                    if (top == '{' && c != '}') return false;
                    break;
                default:
                    return false;
            }
        }
        return true;

    }

    //O(N),O(1)
    public static boolean hasBalancedParenthsis2(String str) {
        int p1 = 0;
        int p2 = str.length() - 1;

        while (p1 <= p2) {
            char c1 = str.charAt(p1);
            char c2 = str.charAt(p2);

            if (c1 == '(' && c2 != ')') return false;
            if (c1 == '[' && c2 != ']') return false;
            if (c1 == '{' && c2 != '}') return false;

            p1++;
            p2--;
        }
        return true;
    }

    //O(N^2)
    public static void stockSpan(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int span = 1;
            while (j >= 0 && arr[i] >= arr[j]) {
                span++;
                j--;
            }

            System.out.print(span + " ");
        }
    }

    public static void stockSpan2(int[] arr, int n) {
        if (n == 0) return;

        Stack<Item> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(new Item(arr[i], 1));
                System.out.print("1 ");
                continue;
            }
            Item top = s.peek();
            if (top.data > arr[i]) {
                s.push(new Item(arr[i], 1));
                System.out.print("1 ");
            } else {
                int span = 1;

                while (!s.isEmpty() && s.peek().data <= arr[i]) {
                    Item it = s.pop();
                    int ct = it.min;
                    span += ct;
                }
                s.push(new Item(arr[i], span));
                System.out.print(span + " ");
            }
        }

        System.out.println();
    }

    public static void printNxtGrtElem(int[] arr, int n) {
        int[] res = new int[n];
        int max = -1;
        res[n - 1] = max;
        max = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] > arr[i]) {
                res[i] = arr[i + 1];
            } else {
                res[i] = arr[i] < max ? max : -1;
            }
            max = Math.max(arr[i], max);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    //using stack. O(N),O(N)
    public static void printNxtGrtElem2(int[] arr, int n) {
        if (n == 0) return;

        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);

        for (int i = 1; i < n; i++) {

            int next = arr[i];

            if (next > s.peek()) {
                while (!s.isEmpty() && s.peek() < next) {
                    System.out.println(s.pop() + " --> " + next);
                }
            }
            s.push(next);
        }

        while (!s.isEmpty()) System.out.println(s.pop() + " --> -1");
    }
}
