import java.lang.reflect.WildcardType;
import java.util.HashSet;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
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
    public boolean hasCycle(ListNode head) {
        return hasCycle4(head);
    }

    /** 第二刷 **/
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> list = new HashSet<>();

        while(head != null) {
            if(!list.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode qucik = head.next;

        while(slow != qucik) {
            if(qucik == null || qucik.next == null) {
                return false;
            }

            slow = slow.next;
            qucik = qucik.next.next;
        }
        return true;
    }


    /** 第三刷 **/
    public boolean hasCycle3(ListNode head) {
        HashSet<ListNode> nodeList = new HashSet<>();

        while(head != null){
            if(!nodeList.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle4(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode quick = head.next;

        while(slow != quick) {
            if(quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
// @lc code=end

