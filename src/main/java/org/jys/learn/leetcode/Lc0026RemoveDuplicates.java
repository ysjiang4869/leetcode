package org.jys.learn.leetcode;

import java.util.Arrays;

/**
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (42.48%)
 * Likes:    1830
 * Dislikes: 3998
 * Total Accepted:    738.4K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 * @author YueSong Jiang
 * @date 2019/11/22
 */
public class Lc0026RemoveDuplicates {

    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums=new int[]{3,2,2,3,5};
        Arrays.sort(nums);
        int res=solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,res)));
    }

    static class Solution {
        /**
         * in this solution , if find duplicate, keep the last one
         * @param nums array
         * @return array length
         */
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int i=0;
            //two pointers all begin from 0
            for(int j=0; j<nums.length-1; j++){
                if(nums[j]!=nums[j+1]){
                    nums[i]=nums[j];
                    i++;
                }
            }
            nums[i]=nums[nums.length-1];
            return i+1;
        }

        /**
         * in this solution , if find duplicate, keep the first one
         * @param nums array
         * @return array length
         */
        public int removeDuplicates2(int[] nums) {
            int i=0;
            // one pointer begin from 0, another from 1
            for(int j=1;j<nums.length;j++){
                if(nums[i]!=nums[j]){
                    i++;
                    nums[i]=nums[j];
                }
            }
            return i+1;
        }
    }
}
