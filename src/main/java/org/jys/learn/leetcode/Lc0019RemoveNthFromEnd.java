package org.jys.learn.leetcode;

import org.jys.learn.leetcode.common.ListNode;

/**
 * [19] Remove Nth Node From End of List
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * <p>
 * algorithms
 * Medium (34.25%)
 * Likes:    1889
 * Dislikes: 136
 * Total Accepted:    406.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * <p>
 * Example:
 * <p>
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * <p>
 * <p>
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 *
 * @author YueSong Jiang
 * @date 2019/11/18
 */
public class Lc0019RemoveNthFromEnd {

    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode lead = new ListNode(0);
            lead.next = head;
            ListNode firstp = lead;
            ListNode secondp = lead;
            int i = 0;
            while (i < n) {
                firstp = firstp.next;
                i++;
            }
            while (firstp.next != null) {
                firstp = firstp.next;
                secondp = secondp.next;
            }

            secondp.next = secondp.next.next;
            return lead.next;
        }
    }

}
