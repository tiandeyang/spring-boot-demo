package com.dytian.testcode.linked.list;

public class HasCycle {


    public boolean hasCycle(ListNode head) {

        if (null == head || head.next == null){
            return false;
        }

        ListNode next = head;
        ListNode next2 = head;

        boolean flag = false;
        while (next != null && next2 != null){
            next = next.next;
            if (null == next2.next){
                break;
            }
            next2 = next2.next.next;

            if (next == next2){
                flag = true;
                break;
            }
        }

        return flag;
    }

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
