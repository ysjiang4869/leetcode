package org.jys.learn.leetcode;

import java.util.Arrays;

/**
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.78%)
 * Likes:    1156
 * Dislikes: 84
 * Total Accepted:    355.6K
 * Total Submissions: 776.9K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0016ThreeSumCloest {

    class Solution {
        public int threeSumClosest(int[] nums, int target) {

            int ret=Integer.MAX_VALUE;

            // if (nums.length < 3) {
            //     return ret;
            // }

            Arrays.sort(nums);
            //the last two no ned to calculate anymore
            int distance=Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int sum = target-nums[i];
                if (i > 0 && nums[i] == nums[i - 1]) {
                    //remove duplicate
                    continue;
                }
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    int newSum=sum-(nums[lo]+nums[hi]);
                    if (nums[lo] + nums[hi] == sum) {
                        return target;
                        // while (lo < hi && nums[lo + 1] == nums[lo]) {
                        //     //remove duplicate
                        //     lo++;
                        // }

                        // while (lo < hi && nums[hi] == nums[hi - 1]) {
                        //     //remove duplicate
                        //     hi--;
                        // }
                        // //get the answer, move both pointer
                        // lo++;
                        // hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                    if(Math.abs(newSum) < Math.abs(distance)){
                        distance=newSum;
                        ret=sum-newSum+nums[i];
                    }
                }
            }

            return ret;
        }
    }
}
