package com.dytian.testcode.linked.list;


public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode pReversedHead = null; //反转过后的单链表存储头结点
        ListNode pNode = head; //定义pNode指向pHead;
        ListNode pPrev = null; //定义存储前一个结点
        while(pNode != null){
            ListNode pNext = pNode.next; //定义pNext指向pNode的下一个结点
            if(pNext==null){ //如果pNode的下一个结点为空，则pNode即为结果
                pReversedHead = pNode;
            }
            pNode.next = pPrev; //修改pNode的指针域指向pPrev
            pPrev = pNode; //将pNode结点复制给pPrev
            pNode = pNext; //将pNode的下一个结点复制给pNode
        }
        return pReversedHead;

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

        ReverseList removeNthFromEnd = new ReverseList();
        ListNode tail = removeNthFromEnd.reverseList(headNode);
      //  System.out.println(tail.val);
        ListNode he = tail;
        while (he != null){
            System.out.println("he==="+he.val);
        //    System.out.println(he.val);
            he = he.next;
        }


    }

}
