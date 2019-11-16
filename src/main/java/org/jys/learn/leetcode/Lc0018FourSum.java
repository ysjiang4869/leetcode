package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.51%)
 * Likes:    1114
 * Dislikes: 220
 * Total Accepted:    240.9K
 * Total Submissions: 782.4K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */


public class Lc0018FourSum {

    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums=new int[]{-3,-2,-1,0,0,1,2,3};
        int target=0;
        List<List<Integer>> ret=solution.fourSum(nums,target);
        System.out.println(ret);
    }


    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            Arrays.sort(nums);

            return nSum(nums, 0, target, 4);
        }

        /**
         *
         * @param nums origin array
         * @param start the start position of array to search, use main for recursive
         * @param target the target sum
         * @param n n sum
         * @return the n sum result
         */
        private List<List<Integer>> nSum(int[] nums, int start, int target, int n) {

            List<List<Integer>> result = new ArrayList<>();
            // nSum when n >2
            if (n > 2) {
                for (int i = start; i < nums.length-n+1 ; i++) {
                    List<List<Integer>> nResult = nSum(nums, i + 1, target - nums[i], n - 1);
                    for (List<Integer> item : nResult) {
                        item.add(nums[i]);
                        result.add(item);
                    }
                    //remove duplicate
                    while ((i+1<nums.length)&&(nums[i]==nums[i+1])){
                        i++;
                    }
                }
            }

            //for 2 sum ,use two pointer
            if (n == 2) {
                int lo = start;
                int hi = nums.length - 1;

                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum == target) {
                        List<Integer> find=new ArrayList<>(2);
                        find.add(nums[lo]);
                        find.add(nums[hi]);
                        result.add(find);
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            //remove duplicate
                            hi--;
                        }
                        while (lo < hi && nums[lo] == nums[lo] + 1) {
                            //remove duplicate
                            lo++;
                        }
                        hi--;
                        lo++;
                    } else if (sum > target) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
            return result;
        }
    }
}
