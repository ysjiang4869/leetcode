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
        Solution2 solution = new Solution2();
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

        nums = new int[]{3, 5, 1};
        System.out.println(solution.search(nums, 1) == 2);

        nums = new int[]{5, 1, 3};
        System.out.println(solution.search(nums, 1) == 1);
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

    static class Solution2{
        public int search(int[] nums, int target) {

            if(nums.length==0){
                return -1;
            }

            if(nums.length==1&& nums[0]!=target){
                return -1;
            }

            //二分法查找分界点,
            //分界点是第一个小于num[0]的值
            //思路1是查找左边界，第一个小于num[0]的值
            //思路2是查找右边界，即，最后一个递增的值，下一个就是转折点
            //两种思路都行，关键是，在后面取lo和hi分半判断的时候，要注意lo=hi=mid的情况
            //这里是思路2
            int lo=0,hi=nums.length-1;
            int mid=0;
            while (lo<hi){
                mid=lo+((hi-lo)>>1)+1;
                if(nums[mid]>nums[0]){
                    lo=mid;
                }else {
                    hi=mid-1;
                }
            }

            //判断查找那一半
            //lo/mid=第一个转折点，hi=lo/lo+1
            //注意：查找左右边界，返回值应该是lo和hi，不是mid，这种情况可能mid!=lo？
            if(target>=nums[0]){
                //查找左边一半
                //hi=hi;//hi一定是最后一个递增，这个地方没错
                lo=0;
            }else {
                //查找右边
                //hi一定是最后一个递增，要取下一个值
                lo=Math.min(nums.length-1,hi+1);
                hi=nums.length-1;

            }

            while (lo<=hi){
                mid=lo+((hi-lo)>>1);
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                   hi=mid-1;
                }else {
                    lo=mid+1;
                }
            }

            return -1;

        }
    }

    static class Solution3{
        public int search(int[] nums, int target) {

            if(nums.length==0){
                return -1;
            }

            if(nums.length==1&& nums[0]!=target){
                return -1;
            }

            //二分法查找分界点,
            //分界点是第一个小于num[0]的值
            //思路1是查找左边界，第一个小于num[0]的值
            //思路2是查找右边界，即，最后一个递增的值，下一个就是转折点
            //两种思路都行，关键是，在后面取lo和hi分半判断的时候，要注意lo=hi=mid的情况
            //这里使用有边界
            int lo=0,hi=nums.length-1;
            int mid=0;
            while (lo<hi){
                mid=lo+((hi-lo)>>1);
                if(nums[mid]<nums[0]){
                    hi=mid;
                }else {
                    lo=mid+1;
                }
            }

            //判断查找那一半
            //lo/mid=第一个转折点，hi=lo/lo+1
            if(target>=nums[0]){
                //查找左边一半
                //hi是第一个变小的，所以应该用hi-1
                //但是存在全部递增，就没有hi，这时候hi应该是nums.length-1且该点不是拐点,就不需要减一了
                if(nums.length-1==hi&&hi>0&&nums[hi]>nums[hi-1]){
                    hi=hi;
                }else {
                    hi= Math.max(hi - 1, 0);//预防临界值
                }
                lo=0;

            }else {
                //查找右边
                //mid一定是右半第一个元素
                lo=hi;
                hi=nums.length-1;
            }

            while (lo<=hi){
                mid=lo+((hi-lo)>>1);
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    hi=mid-1;
                }else {
                    lo=mid+1;
                }
            }

            return -1;

        }
    }
}
