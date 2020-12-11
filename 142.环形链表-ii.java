import java.util.HashSet;

import sun.tools.tree.ShiftLeftExpression;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        return detectCycle2_1(head);
    }

    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> nodeList = new HashSet<>();

        while(head != null){
            if(!nodeList.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2_1(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while(quick != null) {
            if(quick.next != null) {
                slow = slow.next;
                quick = quick.next.next;
            } else {
                return null;
            }

            if(quick == slow) {
                ListNode ptr = head;
                while(ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    
    }
    public ListNode detectCycle2(ListNode head) {
        //quick 距离头节点的距离必须是 slow 距头节点距离的 2 倍 
        ListNode slow = head;
        ListNode quick = head;

        while(quick != null){
            if(quick.next != null){
                quick = quick.next.next;
                slow = slow.next;
            } else {
                return null;
            }
            if(quick == slow){
                ListNode ptr = head;
                while(ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        } 

        // ListNode ptr = head;
        // while(slow != ptr) {
        //     ptr = ptr.next;
        //     slow = slow.next;
        // }

        return null;
    }

}
// @lc code=end

