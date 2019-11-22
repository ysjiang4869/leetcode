package org.jys.learn.leetcode;

import org.jys.learn.leetcode.common.ListNode;

/**
 * [24] Swap Nodes in Pairs
 * <p>
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * <p>
 * algorithms
 * Medium (47.10%)
 * Likes:    1516
 * Dislikes: 137
 * Total Accepted:    376K
 * Total Submissions: 798.2K
 * Testcase Example:  '[1,2,3,4]'
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author YueSong Jiang
 * @date 2019/11/22
 */
public class Lc0024SwapNodesInPair {

    class Solution {
        public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode sec;
            while (head != null && head.next != null) {
                sec = head.next;
                head.next = sec.next;
                sec.next = head;
                pre.next = sec;
                pre = head;
                head = head.next;
            }

            return dummy.next;
        }
    }
}
