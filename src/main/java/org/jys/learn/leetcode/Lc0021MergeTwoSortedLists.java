package org.jys.learn.leetcode;

import org.jys.learn.leetcode.common.ListNode;

/**
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.92%)
 * Likes:    2901
 * Dislikes: 420
 * Total Accepted:    746.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author YueSong Jiang
 * @date 2019/11/18
 */
public class Lc0021MergeTwoSortedLists {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // prevent edge cases
            ListNode head=new ListNode(0);
            ListNode another=l2;
            head.next=l1;
            ListNode dummy=head;
            while(head.next!=null&&another!=null){
                if(head.next.val>another.val){
                    ListNode change=another;
                    another=head.next;
                    head.next=change;
                }
                head=head.next;
            }
            if(another==null){
                return dummy.next;
            }else{
                head.next=another;
            }
            return dummy.next;
        }
    }
}
