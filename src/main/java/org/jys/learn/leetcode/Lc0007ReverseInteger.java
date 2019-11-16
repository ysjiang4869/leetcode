package org.jys.learn.leetcode;

/**
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.31%)
 * Likes:    2205
 * Dislikes: 3386
 * Total Accepted:    711.9K
 * Total Submissions: 2.8M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 *
 * Input: 123
 * Output: 321
 *
 *
 * Example 2:
 *
 *
 * Input: -123
 * Output: -321
 *
 *
 * Example 3:
 *
 *
 * Input: 120
 * Output: 21
 *
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0007ReverseInteger {

    class Solution {
        public int reverse(int x) {

            //use long to revert int overflow
            long ret=0;
            while(x!=0){
                int pop=x%10;
                ret=ret*10+pop;
                if(ret>Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
                    return 0;
                }
                x=x/10;
            }
            return (int)ret;
        }
    }
}
