package org.jys.learn.leetcode;

/**
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (31.85%)
 * Likes:    1053
 * Dislikes: 3287
 * Total Accepted:    326.1K
 * Total Submissions: 1M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 *
 * Example 2:
 *
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0006ZigZagConversion {

    class Solution {
        public String convert(String s, int numRows) {
            char[] result=new char[s.length()];

            //if only one row, just return,
            //bellow black_sub will be 0 and may cause problem
            if(numRows==1){
                return s;
            }
            //process first row
            int i=0;
            int black_sub=2*numRows-2;
            for(int index=0;index<s.length();){
                result[i]=s.charAt(index);
                index+=black_sub;
                i++;
            }

            //process medium row
            for(int j=1;j<numRows-1;j++){
                int red_sub=(numRows-j-1)*2;
                for(int index=j;index<s.length();){
                    //get the black num
                    result[i++]=s.charAt(index);
                    //judge the read num if large than length
                    if(index+red_sub>=s.length()){
                        break;
                    }
                    //get the read num
                    result[i++]=s.charAt(index+red_sub);
                    //index add to the next black num
                    index+=black_sub;
                }
            }

            //process last row
            for(int index=numRows-1;index<s.length();){
                result[i]=s.charAt(index);
                index+=black_sub;
                i++;
            }

            return new String(result);
        }
    }
}
