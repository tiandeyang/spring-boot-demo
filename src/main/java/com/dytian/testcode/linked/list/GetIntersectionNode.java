package com.dytian.testcode.linked.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<Integer> listNodes = new HashSet<>();
        if (null == headA || null == headB  || headA.next == null || headB.next == null){
            return null;
        }

        ListNode interSection = null;
        while (headA != null){
            boolean booleanA = listNodes.add(headA.val);
            if (!booleanA){
                System.out.println(1);
                interSection = headA;
                break;
            }
            headA = headA.next;
        }

        while (headB != null){
            boolean booleanB = listNodes.add(headB.val);
            if (!booleanB){
                System.out.println(2);
                interSection = headB;
                break;
            }
            headB = headB.next;
        }
        return  interSection;


    }

    public static void main(String[] args) {


    }




}
