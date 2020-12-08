package leetcode;

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
}
