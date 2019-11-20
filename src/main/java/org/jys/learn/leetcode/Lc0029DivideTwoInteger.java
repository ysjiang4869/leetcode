package org.jys.learn.leetcode;

/**
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.17%)
 * Likes:    852
 * Dislikes: 4085
 * Total Accepted:    229K
 * Total Submissions: 1.4M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 *
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 *
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 *
 * @author YueSong Jiang
 * @date 2019/11/20
 */
public class Lc0029DivideTwoInteger {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.divide(-2147483648, -1));

    }


    static class Solution {
        public int divide(int dividend, int divisor) {
            boolean falsePositive = (dividend ^ divisor) < 0;

            //考虑溢出的边界情况,即-2^31转换为正数会出问题,采取long
            long dividendL= dividend;
            long divisorL= divisor;

            // convert to positive
            dividendL = dividendL > 0 ? dividendL : (~dividendL + 1);
            divisorL = divisorL > 0 ? divisorL : (~divisorL + 1);

            long result = 0;
            for (int i = 31; i >= 0; i--) {
                //除数右移i位还大于等于被除数，这一位才不为0
                if ((dividendL >> i) >= divisorL) {
                    result = result + (1 << i);
                    //注意括号和运算优先级
                    dividendL = dividendL - (divisorL << i);
                }
            }

            if(result<0&&!falsePositive){
                //结果超过最大值了，如果不是负数，就返回inter max
                return Integer.MAX_VALUE;
            }

            if (falsePositive) {
                result = ~result + 1;
            }

            return (int)result;
        }

    }
}
