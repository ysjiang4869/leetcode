package org.jys.learn.leetcode;

/**
 *
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (14.65%)
 * Likes:    974
 * Dislikes: 6106
 * Total Accepted:    374.4K
 * Total Submissions: 2.6M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (2^31 − 1) or
 * INT_MIN (−2^31) is returned.
 *
 *
 * Example 1:
 *
 *
 * Input: "42"
 * Output: 42
 *
 *
 * Example 2:
 *
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 *
 *
 * Example 3:
 *
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 *
 *
 * Example 4:
 *
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 *
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0008StringToInteger {

    class Solution {
        public int myAtoi(String str) {
            str = str.trim(); //Trim any of the white space at the end or the beginnig of the string
            int retVal = 0; //The value to return
            int num; //Temporarily hold the char as an int
            int neg = 1; //The sign of the number

            //Check numbers between 48-57 The ascii values of '0'-'9'
            for(int i = 0; i < str.length(); i++) {
                num = str.charAt(i);

                //The char is not a number
                if(num < 48 || num > 57) {
                    //The char is a negative sign '-'
                    if(num == 45 && i == 0) {
                        neg = -1; //Set the value to negative
                        continue; //Do not set any of the values
                    }
                    //The char is a plus sign '+'
                    else if(num == 43 && i == 0) {
                        continue; //Do not set any of the values
                    }
                    //Since we got a char that is not a number return the value
                    else {
                        return neg * retVal;
                    }
                }
                num -= 48; //Set the value of char to the acutal value of the int
                num += (retVal * 10); //Shift the retVal by 10 and add num to it.

                //Check to see that the retVal will not overflow by multiplying it by 10, or if the number changed to a negative.
                if(retVal > 2147483647/10 || num < 0) {
                    if(neg == 1) {
                        return 2147483647; //Positive overflow
                    } else {
                        return -2147483648; //Negative overflow
                    }
                }
                retVal = num; //Set the retVal to num
            }
            return neg*retVal; //return the final value
        }
    }

}
