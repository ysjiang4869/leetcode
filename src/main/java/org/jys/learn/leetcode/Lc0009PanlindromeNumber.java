package org.jys.learn.leetcode;

/**
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (43.34%)
 * Likes:    1458
 * Dislikes: 1310
 * Total Accepted:    597.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 *
 * Example 1:
 *
 *
 * Input: 121
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 *
 *
 * Example 3:
 *
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 *
 *
 * Follow up:
 *
 * Could you solve it without converting the integer to a string?
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0009PanlindromeNumber {

    class Solution {
        public boolean isPalindrome(int x) {
            if(x<0){
                return false;
            }

            if(x%10==0 && x!=0){
                return false;
            }

            int reverse=0;
            int origin=x;
            while(x!=0){
                int pop=x%10;
                reverse=reverse*10+pop;
                x=x/10;
            }

            return reverse==origin;
        }
    }
}
