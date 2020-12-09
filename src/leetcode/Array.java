package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Array {

    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    unfinshed solution
     */
    public static int removeDuplicates(int[] nums) {
        int p1 = 0, p2 = 1, upper = nums.length - 1;
        while (p1 < p2 && p1 < upper && p2 <= upper) {
            if (nums[p1] == nums[p2]) {
                ++p2;
                continue;
            } else {
                nums[p1 + 1] = nums[p2];
                ++p1;
                ++p2;
            }
        }

        return p1 + 1;
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
        if (nums[high] == target) return high;
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

    /*
        sorted array, find first and last position of an element
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     */
    public static int[] searchRange(int[] nums, int target) {
        int first = floor(nums, target);
        int last = ceil(nums, target);
        return new int[]{first, last};
    }

    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                if (mid == 0) return mid;
                if (mid > 0 && arr[mid - 1] < target) return mid;
                else high = mid - 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                if (mid == arr.length - 1) return mid;
                if (mid < arr.length - 1 && arr[mid + 1] > target) return mid;
                else low = mid + 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /*
        https://leetcode.com/problems/first-missing-positive/
     */
    public static int firstMissingPositive(int[] nums) {
        int max = 0;
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hash.contains(nums[i])) hash.add(nums[i]);
            if (nums[i] > max) max = nums[i];
        }

        for (int i = 1; i < max; i++) {
            if (hash.contains(i)) continue;
            return i;
        }

        return max + 1;
    }

    /*
        https://leetcode.com/problems/missing-number/
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = 0;
        int actualSum = 0;
        for (int i = 1; i <= n; i++) expectedSum += i;
        for (int i = 0; i < n; i++) {
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }

    /*
        https://leetcode.com/problems/find-the-duplicate-number/
     */
    public static int findDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) return nums[i];
            hash.add(nums[i]);
        }
        return -1;
    }

    /*
        non repeating number
        https://leetcode.com/problems/single-number/
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    /*
        https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.contains(nums[i])) hash.add(nums[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (hash.contains(i)) continue;
            else result.add(i);
        }

        return result;
    }

    /*
        in place, no extra space, O(N)
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            nums[j] = Math.abs(nums[j]) * -1;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
