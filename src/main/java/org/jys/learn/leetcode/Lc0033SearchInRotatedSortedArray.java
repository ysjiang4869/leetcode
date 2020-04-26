package org.jys.learn.leetcode;

/**
 * @author YueSong Jiang
 * @date 2020/4/24
 * @lc app=leetcode id=33 lang=java
 * <p>
 * [33] Search in Rotated Sorted Array
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * <p>
 * algorithms
 * Medium (33.63%)
 * Likes:    3961
 * Dislikes: 410
 * Total Accepted:    598.4K
 * Total Submissions: 1.8M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Lc0033SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums, 0) == 4);
        System.out.println(solution.search(nums, 3) == -1);
        nums = new int[]{1};
        System.out.println(solution.search(nums, 0) == -1);
        System.out.println(solution.search(nums, 1) == 0);

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.search(nums, 0) == -1);
        System.out.println(solution.search(nums, 1) == 0);

        nums = new int[]{1, 3};
        System.out.println(solution.search(nums, 0) == -1);
        System.out.println(solution.search(nums, 3) == 1);

        nums = new int[]{3, 1};
        System.out.println(solution.search(nums, 0) == -1);
        System.out.println(solution.search(nums, 3) == 0);
    }

    static class Solution {
        public int search(int[] nums, int target) {

            if (nums.length == 0) {
                return -1;
            }

            //first, find the rotated point
            int lo = 0, hi = nums.length - 1;
            int mid = (hi + lo) / 2;
            while (lo <= hi) {
                if (nums[mid] < nums[0]) {
                    // 边界条件，只有2个元素的时候
                    if (nums[mid - 1] >= nums[0]) {
                        break;
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    lo = mid + 1;
                }
                mid = (hi + lo) / 2;
            }

            if (nums[0] <= target) {
                lo = 0;
                //边界条件，全部递增的情况，没有转折点
                hi = mid == nums.length - 1 ? nums.length - 1 : mid - 1;
            } else {
                lo = mid;
                hi = nums.length - 1;
            }

            mid = (hi + lo) / 2;
            while (lo <= hi) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
                mid = (hi + lo) / 2;
            }
            return -1;

        }
    }
}
