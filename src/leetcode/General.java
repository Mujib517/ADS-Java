package leetcode;

import java.util.HashMap;
import java.util.Map;

public class General {

    /*
    https://leetcode.com/problems/two-sum/
    x+y = k return indexes of x and y
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    // extra space O(N)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int valueNeeded = target - nums[i];
            if (map.containsKey(valueNeeded) && map.get(valueNeeded) != i)
                return new int[]{map.get(valueNeeded), i};
        }

        return new int[]{0, 0};
    }

    /*
    https://leetcode.com/problems/palindrome-number/
    121 -> true
    -121 -> false
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String res = "";
        while (!stack.isEmpty()) {
            res += (char) stack.pop();
        }

        System.out.println(res + " " + str);

        return res.equals(str);
    }

    /*
       https://leetcode.com/problems/divide-two-integers/submissions/
     */
    public static int divide(long dividend, long divisor) {
        long x = Math.abs(dividend);
        long y = Math.abs(divisor);

        int count = 0;
        while (x >= y) {
            x = x - y;
            ++count;
        }

        if (dividend > 0 && divisor > 0) return count;
        else if (dividend < 0 && divisor < 0) return count;
        return 0 - count;
    }

    /*
        5 = true : 1*1 + 2*2
        4 = true : 2*2
        3 = false
        1 = true : 1*1 + 1*0
        https://leetcode.com/problems/sum-of-square-numbers/
     */
    public static boolean judgeSquareSum(int c) {
        int low = 0, high = (int) Math.sqrt(c);

        while (low < high) {
            int sum = low * low + high * high;
            if (sum == c) return true;
            if (sum > c) --high;
            if (sum < c) ++low;
        }
        return false;
    }

    /*
        https://leetcode.com/problems/length-of-last-word/
     */
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) return 0;
        return words[words.length - 1].length();
    }

    /*
        https://leetcode.com/problems/rearrange-spaces-between-words/
     */
    public static String reorderSpaces(String text) {
        int spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') spaces++;
        }
        String[] words = text.trim().split(" +");
        int spacesToAdd = spaces / (words.length - 1);

        String result = "";
        int spacesEnd = spaces - ((words.length - 1) * spacesToAdd);

        String spaceString = "";
        String endString = "";
        for (int i = 0; i < spacesToAdd; i++) spaceString += " ";
        for (int i = 0; i < spacesEnd; i++) endString += " ";

        for (int i = 0; i < words.length; i++) {
            result += words[i];

            if (i == words.length - 1) break;
            result += spaceString;
        }

        return result + endString;
    }
}
