package org.jys.learn.leetcode;

/**
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.29%)
 * Likes:    3711
 * Dislikes: 356
 * Total Accepted:    573.6K
 * Total Submissions: 2.1M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0005LongestPalindrome {

    class Solution {
        public String longestPalindrome(String s) {
            boolean[][]dp=new boolean[s.length()][s.length()];

            //init value is 0 to prevent empty str
            int maxLen=0;
            //process len is 1
            // 初始化1.每个单字设置为true
            for(int i=0; i<s.length(); i++){
                dp[i][i]=true;
                maxLen=1;
            }

            // means palindromic start position
            //回文字符串的起始位置
            int left=0;
            //process len is 2
            // 初始化2. 相邻的字符相等也是回文,设置为true
            for(int i=0; i<s.length()-1; i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1]=true;
                    maxLen=2;
                    left=i;
                }
            }

            //process len>=3
            // 递推 寻找长度为3和3以上的回文子串
            for(int len=3; len<=s.length();len++){ // 当前子串长度为len
                for(int i=0; i<=s.length()-len;i++){ // 当前子串起始位置i
                    int j=i+len-1; // 子串尾端位置j. j-i=len-1
                    if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                        // if条件句解释: 1. 当前子串长度为3时, i+1=j-i=中间的字符
                        // 2. 当前子串长度为4时, i+1+1=j-i 即初始化2中检查相邻字符是否一样
                        // 也就是说,以每个字符为起始的每个长度的子串都做了判断,并将结果存储在了dp[][]中
                        // 下一轮长度+1时,可利用上一轮的判断结果
                        // 每一个字符,都遍历了长度1~n的子串,所以时间复杂度O(n^2)
                        dp[i][j]=true;
                        maxLen=len;
                        left=i;
                    }
                }
            }
            return s.substring(left, left + maxLen);
        }
    }
}
