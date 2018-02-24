package Stacks;

import java.util.Stack;

/*
    Important problems
    1. prefix calculation
    2. postfix calculation
    3. max area under histogram
    4. stock span
 */

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

    //Min brancket reverse to form a balanced string
    public static int minimumBracketReversal(String str) {

        if (str.length() % 2 != 0) return -1;

        int p1 = 0, p2 = str.length() - 1;
        int m = 0, n = 0;

        while (p1 <= p2) {

            if (str.charAt(p1) == '{' && str.charAt(p2) == '}') {
                p1++;
                p2--;
                continue;
            }
            ;
            if (str.charAt(p1) == '{') m++;
            else n++;
            if (str.charAt(p2) == '}') n++;
            else m++;

            p1++;
            p2--;
        }
        return (m / 2) + (n / 2);
    }

    public static int evaluatePostfix(String str) throws Exception {
        if (str.length() == 0) return -1;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);


            if (isOperand(ch)) s.push(Integer.parseInt(ch.toString()));
            else {
                if (s.size() < 2) throw new Exception("Invalid Postfix Expression");

                int b = s.pop();
                int a = s.pop();

                int res = calculate(a, b, ch);
                s.push(res);
            }
        }
        return s.pop();
    }

    public static int evaluatePrefix(String str) throws Exception {
        if (str.length() == 0) return 0;

        Stack<Integer> s = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            Character ch = str.charAt(i);
            if (isOperand(ch)) s.push(Integer.parseInt(ch.toString()));
            else {
                if (s.size() < 2) throw new Exception("Invalid Prefix Expression");
                int a = s.pop();
                int b = s.pop();
                int result = calculate(a, b, ch);
                s.push(result);
            }
        }
        return s.pop();
    }

    public static int maxAreaBruteForce(int[] arr, int n) {
        int max = getMax(arr, n);

        for (int i = 1; i <= max; i++) {
            int maxSofar = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i) maxSofar += i;
                else {
                    max = Math.max(max, maxSofar);
                    maxSofar = 0;
                }
            }
            max = Math.max(max, maxSofar);
        }
        return max;
    }

    public static int maxArea(int[] arr, int n) {
        Stack<Integer> heights = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        int largestSize = 0;

        for (int i = 0; i < n; i++) {
            if (heights.isEmpty() || heights.peek() < arr[i]) {
                heights.push(arr[i]);
                indexes.push(i);
            } else if (heights.peek() > arr[i]) {
                int lastIndex = 0;

                while (!heights.isEmpty() && heights.peek() > arr[i]) {
                    lastIndex = indexes.pop();
                    int tempArea = heights.pop() * (i - lastIndex);
                    largestSize = Math.max(largestSize, tempArea);
                }
                heights.push(arr[i]);
                indexes.push(lastIndex);
            }
        }
        while (!heights.isEmpty()) {
            int tempArea = heights.pop() * (n - indexes.pop()); //n last index
            largestSize = Math.max(largestSize, tempArea);
        }

        return largestSize;
    }

    public static int maxAreaOptimalSpace(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();

        int i = 0;
        int max = 0;
        while (i < n) {
            if (s.isEmpty() || arr[s.peek()] <= arr[i]) s.push(i++);
            else {
                int top = s.pop();
                int area = arr[top] * (s.isEmpty() ? i : i - s.peek() - 1);
                max = Math.max(max, area);
            }
        }

        while (!s.isEmpty()) {
            int top = s.pop();
            int area = arr[top] * (s.isEmpty() ? n : n - s.peek() - 1);
            max = Math.max(max, area);
        }

        return max;
    }


    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }


    private static int calculate(int a, int b, char ch) {
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    private static boolean isOperand(char ch) {
        return !(ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }


}
