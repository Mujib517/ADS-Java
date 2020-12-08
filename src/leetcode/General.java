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
}
