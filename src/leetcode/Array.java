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

    /*
        https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
     */
    public static int maxProduct(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                if (product > maxSum) maxSum = product;
            }
        }

        return maxSum;
    }

    // by finding max1 and max2 numbers. O(N) solution
    public static int maxProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int maxIndex = -1; // capture index as there can be duplicates
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max2 && maxIndex != i) max2 = nums[i];
        }

        return (max1 - 1) * (max2 - 1);
    }

    /*
       max number by changing 6 to 9
        https://leetcode.com/problems/maximum-69-number/
     */
    public static int maximum69Number(int num) {
        int temp = num;
        int i = 1;
        int max = num;
        while (temp > 0) {
            int digit = temp % 10;
            temp = temp / 10;
            if (digit == 6) {
                int newNumber = num + i * 3;
                if (newNumber > max) max = newNumber;
            }
            i = i * 10;
        }

        return max;
    }

    /*
        https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
     */
    public int[] sumZero(int n) {
        List<Integer> result = new ArrayList<>();
        if (n % 2 == 0) result.add(0);
        int low = 0 - n, high = n;
        while (true) {
            if (result.size() == n) return toArray(result);
            result.add(low);
            result.add(high);
            ++low;
            --high;
        }
    }

    private static int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /*
        https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
        Input: arr = [17,18,5,4,6,1]
        Output: [18,6,6,6,1,-1]
     */
    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxSoFar = arr[n - 1];
        arr[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            int temp = maxSoFar;
            if (maxSoFar < arr[i]) maxSoFar = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    /*
        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        https://leetcode.com/problems/squares-of-a-sorted-array/
     */

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    /*
        https://leetcode.com/problems/merge-sorted-array/
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] temp = Arrays.copyOf(nums1, m);
        while (i < temp.length && j < n) {
            if (temp[i] < nums2[j]) nums1[k++] = temp[i++];
            else nums1[k++] = nums2[j++];
        }

        while (i < temp.length) nums1[k++] = temp[i++];
        while (j < n) nums1[k++] = nums2[j++];
    }

    /*
        https://leetcode.com/problems/sort-array-by-increasing-frequency/
        [1,1,2,2,2,3]
        Output: [3,1,1,2,2,2]
        1 <= nums.length <= 100
        -100 <= nums[i] <= 100
     */
    public static int[] frequencySort(int[] nums) {
        int[] hash = new int[201];
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] + 100;
            hash[idx] = ++hash[idx];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            int frequency = hash[i];
            while (frequency > 0) {
                int number = i - 100;
                result.add(number);
                --frequency;
            }
        }
        return toArray(result);
    }

    /*
        only lowercase english letters
        https://leetcode.com/problems/first-unique-character-in-a-string/
     */
    public static int firstUniqChar(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            ++hash[index];
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (hash[index] == 1) return i;
        }

        return -1;
    }

    /*
        https://leetcode.com/problems/reverse-string/
        2 pointer technique
     */
    public static void reverseString(char[] s) {
        int p1 = 0, p2 = s.length - 1;
        while (p1 < p2) {
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;
            ++p1;
            --p2;
        }
    }

    // single pointer
    public static void reverseString2(char[] s) {
        int mid = s.length / 2;
        int n = s.length;

        for (int i = 0; i < mid; i++) {
            int indexFromEnd = n - 1 - i;
            char temp = s[indexFromEnd];
            s[indexFromEnd] = s[i];
            s[i] = temp;
        }
    }
}
