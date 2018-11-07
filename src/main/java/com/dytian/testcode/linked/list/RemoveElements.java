package com.dytian.testcode.linked.list;

/**
 * 移除链表元素 删除链表中等于给定值 val 的所有节点
 */
public class RemoveElements {


    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = new ListNode(-1);
        ListNode dummpy = cur;

        // 1 2 6 3 4 5 6
        while(head != null) {
            if(head.val == val) {
                cur.next = null;
            }else {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        return dummpy.next;
    }


//    public ListNode removeElements(ListNode head, int val) {
//
//        ListNode now = new ListNode(-1);
//        ListNode fir = head;
//        ListNode dumpy = now;
//        while (fir != null){
//
//            if (fir.val == val){
//                now.next = fir.next;
//            }else {
//                now.next = head;
//                now = now.next;
//            }
//            fir = fir.next;
//        }
//        return dumpy.next;
//    }




    public static void main(String[] args) {


        ListNode headNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        headNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        RemoveElements removeNthFromEnd = new RemoveElements();
        ListNode tail = removeNthFromEnd.removeElements(headNode,6);
        //  System.out.println(tail.val);
        ListNode he = tail;
        while (he != null){
       //     System.out.println("he==="+he.val);
               System.out.println(he.val);
            he = he.next;
        }


    }

}
