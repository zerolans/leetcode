import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList1_3(head);
    }

    public ListNode reverseList1_1(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        head.next = null;

        return pre;
    }

    public ListNode reverseList1_2(ListNode head) {
        if(head == null) {
            return null;
        } else if(head.next == null) {
            return head;
        } else {
            ListNode n = head.next;
            head.next = null;
            ListNode t = reverseList1_2(n);
            n.next = head;
            return t;
        }
    
    }

    public ListNode reverseList1_3(ListNode head) {
        ListNode cur = head;

        if(head == null) {
            return null;
        }

        while(head.next != null) {
            ListNode t = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = t;
        }

        return cur;
    }

}

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//     }
// }
// @lc code=end

