package org.jys.learn.leetcode;

import java.util.Arrays;

/**
 * @author YueSong Jiang
 * @date 2020/4/24
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (35.11%)
 * Likes:    2776
 * Dislikes: 125
 * Total Accepted:    439.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 */
public class Lc0034FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(nums, 8)));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {

            if(nums.length==0){
                return new int[]{-1,-1};
            }
            //first binary search to find first equal value
            int lo=0;
            int hi=nums.length-1;
            int mid=0;
            while(lo<=hi){
                mid=lo+((hi-lo)>>1);
                if(nums[mid]==target){
                    break;
                }

                if(nums[mid]>target){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }

            //当前，mid/lo就是target或者找不到
            if(nums[mid]!=target){
                return new int[]{-1,-1};
            }

            //分别查找左右数组
            //左半
            lo=0;
            hi=mid;
            while(lo<hi){
                mid=lo+((hi-lo)>>1);
                if(nums[mid]<target){
                    lo=mid+1;
                }else{
                    hi=mid;
                }
            }
            int[] ret=new int[2];
            ret[0]=lo;

            //查找右一半
            lo=mid;
            hi=nums.length-1;
            while(lo<hi){
                mid=lo+((hi-lo)>>1)+1;
                if(nums[mid]>target){
                    hi=mid-1;
                }else{
                    lo=mid;
                }
            }
            ret[1]=hi;
            return ret;
        }
    }
}
