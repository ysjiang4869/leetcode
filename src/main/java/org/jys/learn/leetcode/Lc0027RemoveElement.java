package org.jys.learn.leetcode;

import java.util.Arrays;

/**
 *
 * * [27] Remove Element
 *  *
 *  * https://leetcode.com/problems/remove-element/description/
 *  *
 *  * algorithms
 *  * Easy (46.09%)
 *  * Likes:    1012
 *  * Dislikes: 2164
 *  * Total Accepted:    491K
 *  * Total Submissions: 1.1M
 *  * Testcase Example:  '[3,2,2,3]\n3'
 *  *
 *  * Given an array nums and a value val, remove all instances of that value
 *  * in-place and return the new length.
 *  *
 *  * Do not allocate extra space for another array, you must do this by modifying
 *  * the input array in-place with O(1) extra memory.
 *  *
 *  * The order of elements can be changed. It doesn't matter what you leave
 *  * beyond the new length.
 *  *
 *  * Example 1:
 *  *
 *  *
 *  * Given nums = [3,2,2,3], val = 3,
 *  *
 *  * Your function should return length = 2, with the first two elements of nums
 *  * being 2.
 *  *
 *  * It doesn't matter what you leave beyond the returned length.
 *  *
 *  *
 *  * Example 2:
 *  *
 *  *
 *  * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *  *
 *  * Your function should return length = 5, with the first five elements of nums
 *  * containing 0, 1, 3, 0, and 4.
 *  *
 *  * Note that the order of those five elements can be arbitrary.
 *  *
 *  * It doesn't matter what values are set beyond the returned length.
 *  *
 *  * Clarification:
 *  *
 *  * Confused why the returned value is an integer but your answer is an array?
 *  *
 *  * Note that the input array is passed in by reference, which means
 *  * modification to the input array will be known to the caller as well.
 *  *
 *  * Internally you can think of this:
 *  *
 *  *
 *  * // nums is passed in by reference. (i.e., without making a copy)
 *  * int len = removeElement(nums, val);
 *  *
 *  * // any modification to nums in your function would be known by the caller.
 *  * // using the length returned by your function, it prints the first len
 *  * elements.
 *  * for (int i = 0; i < len; i++) {
 *  * print(nums[i]);
 *  * }
 *
 * @author YueSong Jiang
 * @date 2019/11/21
 */
public class Lc0027RemoveElement {

    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums=new int[]{3,2,2,3,5};
        int res=solution.removeElement2(nums,3);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,res)));
    }

    static class Solution {

        /**
         * @param nums array
         * @param val target to remove
         * @return the new length
         */
        public int removeElement(int[] nums, int val) {
            int i=0;
            for(int j=0; j<nums.length; j++){
                if(nums[j]!=val){
                    nums[i]=nums[j];
                    i++;
                }
            }
            return i;
        }

        /**
         * suit for target val is less
         * but it change the original order
         * @param nums array
         * @param val target to remove
         * @return the new length
         */
        public int removeElement2(int[] nums, int val) {
            int n=nums.length;
            for(int j=0; j<n;){
                if(nums[j]==val){
                    nums[j]=nums[n-1];
                    n--;
                }else {
                    j++;
                }
            }
            return n;
        }
    }
}
