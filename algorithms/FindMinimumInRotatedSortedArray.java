package algorithms;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int result = new FindMinimumInRotatedSortedArray().new Solution().findMin(nums);
        System.out.println(result);
    }

    /**
     * Standard binary search.
     * 
     * Time complexity: O(log n)
     * Space complexity: O(1)
     */
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0;
            int end = nums.length - 1;

            // special condition: no rotation
            if (nums[end] > nums[start]) {
                return nums[start];
            }

            // peak between start & end
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] < nums[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            return nums[end];
        }
    }

    /**
     * Standard binary search.
     * 
     * Time complexity: O(log n)
     * Space complexity: O(1)
     */
    class Solution2 {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0;
            int end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > nums[end]) {
                    // mean that mid is on the upper half, so need to go right
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (nums[start] < nums[end]) {
                return nums[start];
            } else {
                return nums[end];
            }
        }
    }

}
