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
}
