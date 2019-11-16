package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.00%)
 * Likes:    3954
 * Dislikes: 448
 * Total Accepted:    572.6K
 * Total Submissions: 2.4M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0015ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret=new ArrayList<>();

            if(nums.length<3){
                return ret;
            }

            Arrays.sort(nums);
            //the last two no ned to calculate anymore
            for(int i=0;i<nums.length-2;i++){
                int sum=-nums[i];
                if(i>0 && nums[i]==nums[i-1]){
                    //remove duplicate
                    continue;
                }
                int lo=i+1;
                int hi=nums.length-1;

                while(lo<hi){

                    if(nums[lo]+nums[hi]==sum){
                        ret.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo+1]==nums[lo]){
                            //remove duplicate
                            lo++;
                        }

                        while(lo<hi && nums[hi]==nums[hi-1]){
                            //remove duplicate
                            hi--;
                        }
                        //get the answer, move both pointer
                        lo++;
                        hi--;
                    }else if(nums[lo]+nums[hi]<sum){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
            return ret;
        }
    }
}
