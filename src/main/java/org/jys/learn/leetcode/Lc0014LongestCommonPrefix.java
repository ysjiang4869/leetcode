package org.jys.learn.leetcode;

import java.util.Arrays;

/**
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.52%)
 * Likes:    1408
 * Dislikes: 1352
 * Total Accepted:    484.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * @author YueSong Jiang
 *  @date 2019/11/14
 */


public class Lc0014LongestCommonPrefix {

    public static void main(String[] args){
        Solution solution=new Solution();
        String[] stringArray = new String[]{"flower", "flow", "floor"};
        System.out.println(solution.longestCommonPrefix(stringArray));
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {

            int low=0;
            int high=strs.length;

            int num=high-low;
            if(num==2){
                //length is 2, just find and return
                return findCommon(strs[0],strs[1]);
            }else if(num==1){
                //length is 1, just return it self
                return strs[0];
            }else if(num==0){
                return "";
            }else{
                int half=(high+1)/2;
                //split to two part
                String[] leftArray= Arrays.copyOfRange(strs,0,half);
                String[] rightArray=Arrays.copyOfRange(strs,half,high);
                // get the left part common prefix, get the right common prefix
                // then get the final data, use recurive method
                return findCommon(longestCommonPrefix(leftArray),longestCommonPrefix(rightArray));
            }
        }

        private String findCommon(String str1,String str2){
            int minLen=Math.min(str1.length(), str2.length());
            char[] same=new char[minLen];
            for(int i=0; i<minLen;i++){
                char cur=str1.charAt(i);
                if(cur==str2.charAt(i)){
                    same[i]=cur;
                }else{
                    char[] same2=Arrays.copyOfRange(same,0,i);
                    return new String(same2);
                }
            }
            char[] same2=Arrays.copyOfRange(same,0,minLen);
            return new String(same2);
        }
    }
}
