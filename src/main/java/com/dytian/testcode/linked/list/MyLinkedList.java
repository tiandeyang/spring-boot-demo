package com.dytian.testcode.linked.list;


class MyLinkedList {

    private static int size = 0;

    private Node head ;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0){
            return -1;
        }
        if (index > size - 1){
            return -1;
        }
        System.out.println("size=="+size);
        Node fir = head;
        for (int i = 0;i <= index;i++){
            fir = fir.next;
        }
        return fir.getVal();
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node next = head.getNext();
        head.setNext(newNode);
        if (null != next){
            newNode.setNext(next);
        }
        size++;

        System.out.println("size=afterAddAtHead="+size);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0){
            addAtHead(val);
            return;
        }

        Node last = head;
        for (int i = 0;i < size;i++){
            last = last.next;
        }
        Node newNode = new Node(val);
        last.setNext(newNode);
        size++;

        System.out.println("size=afterAddTail="+size);

    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if ( index == 0){
           addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        Node fir = head;
        for (int i = 0;i <= index-1;i++){
            fir = fir.next;
        }
        Node newNode = new Node(val);
        Node next = fir.getNext();
        fir.setNext(newNode);
        newNode.setNext(next);
        size++;

        System.out.println("size=afteraddAtIndex="+size);

    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size){
            return;
        }
        Node fir = head;
        for (int i = 0;i <= index-1;i++){
            fir = fir.next;
        }

        Node toDiscart = fir.getNext();
        // System.out.println("toDiscardNode==="+ Json.toJson(toDiscart));
        Node next = toDiscart.getNext();
        fir.setNext(next);
        size--;


    }

    final class Node{

        private int val;
        private Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        int i = linkedList.get(1);//返回2
        System.out.println(i);
         i = linkedList.get(0);//返回2
        System.out.println(i);
         i = linkedList.get(2);//返回2
        System.out.println(i);

    }

}