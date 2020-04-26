package org.jys.learn.leetcode;

/**
 * @author YueSong Jiang
 * @date 2020/3/28
 *
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (27.37%)
 * Likes:    2914
 * Dislikes: 125
 * Total Accepted:    256.9K
 * Total Submissions: 934.8K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 *
 * Example 2:
 *
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 */
public class Lc0032LongestValidParentheses {

    public static void main(String[] args) {
        Solution solution=new Solution();

        String s="())";
        System.out.println(solution.longestValidParentheses(s)==2);
        s="()())";
        System.out.println(solution.longestValidParentheses(s)==4);
        s="()()(())";
        System.out.println(solution.longestValidParentheses(s)==8);

        s="(()())";
        System.out.println(solution.longestValidParentheses(s)==6);
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() < 2) {
                return 0;
            }
            int max = 0;
            //dp 代表从s0-si以si结尾的子字符串最长有效长度
            //(())() 其dp为[0,0,2,4,0,6]
            //为什么这个定义，在后面判断当si=)的时候，则dp[i-1]代表了以i-i结尾的有效长度N，那i-N-1如果是（，就刚好配对了
            //这时候，就是i-N-2的值+N+2就是匹配的结果
            //这种情况分了三部分，和最后一个)匹配的(是一部分, ()中间是一部分，外部是一部分
            //dp[i]的值不反应当前子字符串的最长匹配，所以需要一个max来保存
            int[] dp = new int[s.length()];
            dp[0] = 0;
            dp[1] = (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;
            max = dp[1];
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = dp[i - 2] + 2;

                    } else {
                        //先判断临界条件是否满足，再判断是否存在那个左侧的(
                        if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            //判断i-N-2那部分是否存在
                            dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;

        }
    }
}
