package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (58.09%)
 * Likes:    3571
 * Dislikes: 208
 * Total Accepted:    421.6K
 * Total Submissions: 725.7K
 * Testcase Example:  '3'
 *
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 *
 *
 * For example, given n = 3, a solution set is:
 *
 *
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 *
 *
 * @author YueSong Jiang
 * @date 2019/11/18
 */
public class Lc0022GenerateParenthesis {

    public static void main(String[] args){
        Solution2 solution=new Solution2();
        List<String> ret=solution.generateParenthesis(3);
        System.out.println(ret);
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret=new ArrayList<String>();

            tryAdd(ret,0,0,"",n);
            return ret;
        }

        /**
         * I think this is a recursive solve, not a really back-tracing,
         * You can view solution2, it gave the: try-->not correct-->back and retry process
         * @param ret result list
         * @param left left has used
         * @param right right has ued
         * @param cur current string
         * @param max max num limit
         */
        private void tryAdd(List<String> ret, int left, int right, String cur, int max){

            if(cur.length()==max*2){
                ret.add(cur);
                return;
            }
            if(left<max){
                // can still add left
                tryAdd(ret,left+1,right, cur+"(", max);
            }

            if(left>right){
                //can still add right
                tryAdd(ret,left,right+1, cur+")", max);
            }

        }
    }

    static class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> ret=new ArrayList<String>();

            tryAdd2(ret,n,n,"");
            return ret;
        }

        private void tryAdd2(List<String> ret, int leftRemain, int rightRemain, String cur){

            if(leftRemain==0&&rightRemain==0){
                ret.add(cur);
                return;
            }

            //this process is: find wrong and back
            if(leftRemain>rightRemain){
                // the left remain more the right remain
                // means we use more right than left, this situation is wrong
                return;
            }
            if(leftRemain>0){
                // can still add left
                tryAdd2(ret,leftRemain-1,rightRemain, cur+"(");
            }

            if(rightRemain>0){
                //can still add right
                tryAdd2(ret,leftRemain,rightRemain-1, cur+")");
            }

        }
    }

}
