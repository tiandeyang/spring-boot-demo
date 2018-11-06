package com.dytian.testcode.linked.list;


/**
 *     给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    // 分析 删除倒数第 n 个节点 即 删除正数 第 N - n + 1 个节点

    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here

        ListNode secondP=head;
        ListNode firP=head;
        for(int i=0;i<n;i++){
            secondP=secondP.next;
        }
        if(secondP==null){
            head=head.next;
            return head;
        }
        while(secondP.next!=null){
            secondP=secondP.next;
            firP=firP.next;
        }
        System.out.println("se==="+secondP.val);
        System.out.println("fir=="+firP.val);
        firP.next=firP.next.next;
        return head;

    }




    public static void main(String[] args) {


        ListNode headNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);


        headNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode tail = removeNthFromEnd.removeNthFromEnd(listNode4, 1);

        System.out.println(tail.val);
        ListNode he = tail;
        while (he != null){
            System.out.println(he.val);
            he = he.next;
        }


    }



}
