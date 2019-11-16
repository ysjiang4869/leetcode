package org.jys.learn.leetcode;

/**
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.27%)
 * Likes:    2685
 * Dislikes: 521
 * Total Accepted:    310.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 *
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 *
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 *
 *
 * Example 3:
 *
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Example 4:
 *
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 *
 *
 * Example 5:
 *
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0010RegularExpression {

    class Solution {
        public boolean isMatch(String s, String p) {
            System.out.println(s);
            System.out.println(p);
            //prevent empyt problem, so add+1
            //[i] means substring length
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            //process edge situation
            //both empyt
            dp[0][0] = true;
            for (int i = 1; i <= s.length(); i++) {
                //p is empty
                dp[i][0] = false;
            }

            for (int j = 1; j <= p.length(); j++) {
                //s is empty, only x*(or x*x*orX*x*x* and so on) can match
                dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                        continue;
                    }
                    if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) != s.charAt(i - 1) && j > 1) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        if (j > 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                            dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || (dp[i][j - 2]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
