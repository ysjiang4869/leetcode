package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YueSong Jiang
 * @date 2020/3/19
 */
public class Lc0030SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        System.out.println(solution.findSubstring(s, words));
        s="barfoofoobarthefoobarman";
        words=new String[]{"bar","foo","the"};
        System.out.println(solution.findSubstring(s, words));
        s="wordgoodgoodgoodbestword";
        words=new String[]{"word","good","best","good"};
        System.out.println(solution.findSubstring(s, words));
        words=new String[]{"fooo","barr","wing","ding","wing"};
        s="lingmindraboofooowingdingbarrwingmonkeypoundcake";
        System.out.println(solution.findSubstring(s, words));
    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ret = new ArrayList<>();
            if (words.length == 0) {
                return ret;
            }

            int wordLen = words[0].length();
            if (s.length() < wordLen * words.length) {
                return ret;
            }

            //TODO words有重复元素怎么办
            Map<String, List<Integer>> wordsMap = new HashMap<>(words.length);
            for (int i = 0; i < words.length; i++) {
                wordsMap.putIfAbsent(words[i], new ArrayList<>());
                wordsMap.get(words[i]).add(i);
            }
            int i = 0;
            int j = 0;
            boolean[] mark = new boolean[words.length];

            for (; i <= s.length() - wordLen;) {
                String sub = s.substring(i, i + wordLen);
                if (wordsMap.containsKey(sub)) {
                    if (allFalse(mark)) {
                        //找到第一个匹配的单词
                        j = i;
                    }

                    boolean allRepeat=true;
                    //处理words中看你单词重复
                    for (int k = 0; k < wordsMap.get(sub).size(); k++) {
                        if (!mark[wordsMap.get(sub).get(k)]) {
                            mark[wordsMap.get(sub).get(k)] = true;
                            allRepeat=false;
                            break;
                        }
                    }

                    if(allRepeat){
                        //重复了
                        mark = new boolean[words.length];
                        i=j+1;
                        continue;
                    }

                    if (allTrue(mark)) {
                        //满足条件
                        ret.add(j);
                        mark = new boolean[words.length];
                        i=j+1;
                        continue;
                    }
                    //这里加的是wordLen不是+1
                    i+=wordLen;
                }else {
                    //下一个单词不是words里面的，从j+1开始
                    mark = new boolean[words.length];
                    i=j+1;
                    //这里j=i，否则出现死循环
                    j=i;
                }
            }
            return ret;
        }

        public boolean allTrue(boolean[] array) {
            boolean ret = true;
            for (int i = 0; i < array.length; i++) {
                ret = ret && array[i];
            }
            return ret;
        }

        public boolean allFalse(boolean[] array) {
            boolean ret = true;
            for (int i = 0; i < array.length; i++) {
                ret = ret && (!array[i]);
            }
            return ret;
        }
    }
}
