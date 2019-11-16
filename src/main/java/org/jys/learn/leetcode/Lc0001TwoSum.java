package org.jys.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.18%)
 * Likes:    10794
 * Dislikes: 361
 * Total Accepted:    1.8M
 * Total Submissions: 4.1M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0001TwoSum {


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap<Integer, Integer>(nums.length);
            for (int i=0; i< nums.length; i++){
                int sub=target-nums[i];
                if(map.containsKey(sub)){
                    return new int[]{map.get(sub),i};
                }
                map.put(nums[i],i);
            }
            throw new RuntimeException();
        }
    }

}
