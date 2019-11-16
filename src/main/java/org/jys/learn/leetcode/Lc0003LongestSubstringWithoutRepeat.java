package org.jys.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.38%)
 * Likes:    5648
 * Dislikes: 318
 * Total Accepted:    956.9K
 * Total Submissions: 3.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 *
 *
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0003LongestSubstringWithoutRepeat {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int max=0;
            int j=0;
            Map<Character,Integer> map=new HashMap<Character,Integer>(s.length());
            char[] chars=s.toCharArray();

            for(int i=0;i<s.length();i++){
                char v=chars[i];
                if(map.containsKey(chars[i])){
                    //prevent such as "abba" ,j=2 first,and j=1 then
                    j=Math.max(j,map.get(v));
                }
                //because use i+1,so there need to add 1
                max=Math.max(max,i-j+1);
                //use i+1 prevent just 1 char
                map.put(v,i+1);
            }
            return max;
        }
    }

}
