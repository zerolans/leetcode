/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
    }

    private ListNode reverseKGroup1(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode tail = preHead;


        while(head != null) {
            for(int i=0; i<k; i++) {
                tail = tail.next;
                if(tail == null) {
                    return preHead.next;
                }
            }

            ListNode nexTail = tail.next;
            ListNode[] reverses = reverseList(head, tail);
            head = reverses[0];
            tail = reverses[1];
            
            preHead.next = head;
            tail.next = nexTail;
            preHead = tail;
        }
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;

        while(prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};

    }
}
// @lc code=end

