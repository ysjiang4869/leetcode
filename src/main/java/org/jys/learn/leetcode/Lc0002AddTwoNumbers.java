package org.jys.learn.leetcode;

/**
 * [2] Add Two Numbers
 * <p>
 * https://leetcode.com/problems/add-two-numbers/description/
 * <p>
 * algorithms
 * Medium (31.13%)
 * Likes:    5308
 * Dislikes: 1365
 * Total Accepted:    899.1K
 * Total Submissions: 2.9M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 * <p>
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */


public class Lc0002AddTwoNumbers {


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean t = false;
            ListNode ret = new ListNode(0);
            ListNode cur = ret;
            int carry = 0;
            while (!t) {
                int v1 = l1 == null ? 0 : l1.val;
                int v2 = l2 == null ? 0 : l2.val;
                int sum = v1 + v2 + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                t = l1 == null && l2 == null;
            }
            if (carry != 0) {
                cur.next = new ListNode(carry);
            }
            return ret.next;
        }
    }
}
