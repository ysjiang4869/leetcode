package org.jys.learn.leetcode;

import org.jys.learn.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * [20] Valid Parentheses
 * <p>
 * https://leetcode.com/problems/valid-parentheses/description/
 * <p>
 * algorithms
 * Easy (36.51%)
 * Likes:    3014
 * Dislikes: 148
 * Total Accepted:    616.4K
 * Total Submissions: 1.7M
 * Testcase Example:  '"()"'
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: "()"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: "()[]{}"
 * Output: true
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: "(]"
 * Output: false
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: "([)]"
 * Output: false
 * <p>
 * <p>
 * Example 5:
 * <p>
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author YueSong Jiang
 * @date 2019/11/18
 */
public class Lc0020ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) {
                return false;
            }
            Map<Character, Character> cupples = new HashMap<>(3);
            cupples.put('{', '}');
            cupples.put('(', ')');
            cupples.put('[', ']');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char item = s.charAt(i);
                //是左半边，放进栈
                if (cupples.containsKey(item)) {
                    stack.push(item);
                } else {
                    //是非法字符或者右半边
                    // 如果栈为空，返回false
                    if (stack.empty()) {
                        return false;
                    }
                    //如果栈非空，取出来，将该元素和栈元素在map对应的右半边对比是否一致
                    Character t = stack.pop();
                    if (!Objects.equals(item, cupples.get(t))) {
                        return false;
                    }
                }
            }
            //最后完全匹配，栈应该为空
            return stack.empty();
        }
    }

}
