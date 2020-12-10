/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        return swapPairs4(head);
    }

    public ListNode swapPairs1(ListNode head){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode tmp = dummyNode;

        while(tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return dummyNode.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            head.next = swapPairs2(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }

    //递归
    public ListNode swapPairs3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            head.next = swapPairs3(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }

    //迭代
    public ListNode swapPairs4(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while(tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = node1.next;

            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return dummyHead.next;
    }
}
// @lc code=end

