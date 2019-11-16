package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.56%)
 * Likes:    2266
 * Dislikes: 305
 * Total Accepted:    403K
 * Total Submissions: 961.2K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 *
 * @author YueSong Jiang
 * @date 2019/11/12
 */

public class Lc0017LetterCombinations {

    public static void main(String[] args){
        Solution solution=new Solution();
        String digits="23";
        List<String> ret=solution.letterCombinations(digits);
        System.out.println(ret);
    }



    private static class Solution {
        public List<String> letterCombinations(String digits) {

            List<String> ret=new ArrayList<String>();
            if(digits==null||digits.length()==0){
                return ret;
            }
            ret.add("");
            for(int i=0;i<digits.length();i++){
                //for each num represent letters, combine with previous list
                ret=combine(ret, getChars(digits.charAt(i)));
            }
            return ret;
        }

        // give a list, for each item in list, add each letter in letters
        private List<String> combine(List<String> origin, char[] letters){
            List<String> ret= new ArrayList<>();
            for (char letter : letters) {
                for (String org : origin) {
                    ret.add(org + letter);
                }
            }
            return ret;
        }

        //get represent characters of specified num
        private char[] getChars(char num){
            char[] ret;
            //ascii '2' is num 50
            //get the distance of num and 50
            int sub=num-50;
            //if num is 7 or 9, have 4 characters
            if(sub==5||sub==7){
                ret=new char[4];
            }else{
                ret=new char[3];
            }

            //first assume that there is 3 letter for each num
            for(int i=0;i<3;i++){
                ret[i]=(char)(97+sub*3+i);
            }
            //for 7 and 9, it has 4 num
            if(sub==5||sub==7){
                ret[3]=(char)(97+sub*3+3);
            }
            //because 7 has 4 num ,so for 8 and 9, each add 1
            if(sub==6||sub==7){
                for(int i=0;i<ret.length;i++){
                    ret[i]=(char)(ret[i]+1);
                }
            }
            return ret;
        }
    }
}
