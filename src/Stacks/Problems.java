package Stacks;

import java.util.Stack;

public class Problems {

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
}
