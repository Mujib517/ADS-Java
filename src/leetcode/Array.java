package leetcode;

import java.util.HashSet;

public class Array {

    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    unfinshed solution
     */
    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!hash.contains(nums[i])) ++count;
            else {
                nums[count - 1] = nums[i];
                hash.add(nums[i]);
            }
        }

        return count - 1;
    }

    /*
        https://leetcode.com/problems/remove-element/
        using 2 pointers
     */
    public int removeElement(int[] nums, int val) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] == val && nums[high] != val) {
                int temp = nums[low];
                nums[low++] = nums[high];
                nums[high--] = temp;
            } else if (nums[low] != val) ++low;
            else if (nums[high] == val) --high;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) ++count;
            else break;
        }
        return count;
    }

    /*
        https://leetcode.com/problems/search-insert-position/
        edge cases
        1. [1],1
        2. [1,3],2
        3. [1,3],3 output: 1
        4. [1,3,5,6],7
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (nums[low] >= target) return 0;
        if (nums[high] < target) return high + 1;
        if(nums[high]==target) return high;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (mid > 0 && nums[mid - 1] < target && nums[mid] > target) return mid;
            else if (mid + 1 < nums.length && nums[mid] < target && nums[mid + 1] > target) return mid + 1;
            if (nums[mid] > target) high = mid;
            else if (nums[mid] < target) low = mid;
        }
        return -1;
    }
}
