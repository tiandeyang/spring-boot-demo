package com.dytian.testcode.linked.list;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {


    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null){
            return null;
        }
        Set<ListNode> listNodes = new HashSet<>();
        listNodes.add(head);

        ListNode fir = null;
        ListNode next = head;
        while (next != null){
           next = next.next;
           if (null == next ){
               break;
           }
            boolean add = listNodes.add(next);
            if (!add){
                fir = next;
                break;
            }
        }
        return fir;
    }


    // 使用两个指针
   /* public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }*/




    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }



}
