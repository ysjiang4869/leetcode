package org.jys.learn.leetcode;

/**
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (33.25%)
 * Likes:    1129
 * Dislikes: 1566
 * Total Accepted:    527.1K
 * Total Submissions: 1.6M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Example 1:
 *
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * @author YueSong Jiang
 * @date 2019/11/20
 */
public class Lc0028StrStr {

    class Solution {
        public int strStr(String haystack, String needle) {

            if(needle.length()==0){
                return 0;
            }

            if(haystack.length()==0||haystack.length()<needle.length()){
                return -1;
            }

            int p1=0;
            int p2=0;

            for(p1=0;p1<haystack.length()-needle.length()+1;p1++){
                p2=0;
                while(p2<needle.length()){
                    if(haystack.charAt(p1+p2)==needle.charAt(p2)){
                        p2++;
                    }else{
                        break;
                    }
                }
                if(p2==needle.length()){
                    return p1;
                }
            }

            return -1;

        }
    }
}
