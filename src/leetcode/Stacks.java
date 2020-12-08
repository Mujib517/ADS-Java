package leetcode;

import java.util.Stack;

public class Stacks {

    /*
        https://leetcode.com/problems/valid-parentheses/
     */
    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.isEmpty()) return false;
            else {
                char item = stack.pop();
                System.out.println(item);
                switch (c) {
                    case ')':
                        if (item != '(') return false;
                        break;
                    case '}':
                        if (item != '{') return false;
                        break;
                    case ']':
                        if (item != '[') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
