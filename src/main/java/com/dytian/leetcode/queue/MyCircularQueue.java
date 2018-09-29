package com.dytian.leetcode.queue;

class MyCircularQueue {
    
    private int head = -1 ;
    private int tail = -1 ;

    private static  Integer[] queue;

    private int capacity ;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new Integer[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if (isFull()){
            return false;
        }
        if (head == -1){
            head = 0;
        }
        if (tail == -1){
            tail = 0;
        }
        if (queue[tail] == null){
            queue[tail] = value;
        }else {
            tail++;
            tail = tail % queue.length;
            queue[tail] = value;
        }
        capacity++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {

        if (isEmpty()){
            System.out.println("is empty");
            return false;
        }
        if (queue[head] != null){
            queue[head] = null;
            capacity--;
            if (!isEmpty()){
                head++;
                head = head % queue.length;
            }
            System.out.println("capaty==="+capacity);
        }
        return true;

    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return  -1;
        }
        System.out.println("head--"+head);
        return  queue[head];
    }


    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        System.out.println("tail==="+tail);
       return  queue[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        System.out.println("isEmpty===capaytiy==="+capacity );
        return capacity == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
       return capacity == queue.length;
    }


    public static void main(String[] args) {




        MyCircularQueue circularQueue = new MyCircularQueue(6); // 设置长度为3

        boolean b = circularQueue.enQueue(6);// 返回true
        System.out.println(b);
       int rear = circularQueue.Rear();// 返回3
        circularQueue.Rear();// 返回3
        circularQueue.deQueue();// 返回true

        circularQueue.enQueue(5);
        circularQueue.Rear();// 返回3
        circularQueue.deQueue();// 返回true
        circularQueue.Front();


        boolean b1 = circularQueue.deQueue();// 返回true
        System.out.println(b1);


//        System.out.println(rear);
//        int rear2 = circularQueue.Front();// 返回3
//        System.out.println(rear2);
//        boolean b4 = circularQueue.deQueue();// 返回true
//        System.out.println(b4);
//        circularQueue.enQueue(5);

      /* boolean b1 = circularQueue.enQueue(2);// 返回true
        System.out.println(b1);

        boolean b2 = circularQueue.enQueue(3);// 返回true
        System.out.println(b2);
        boolean b3 = circularQueue.enQueue(4);// 返回false,队列已满
        System.out.println(b3);

        int rear = circularQueue.Rear();// 返回3
        System.out.println(rear);

        boolean full = circularQueue.isFull();// 返回true
        System.out.println(full);

        boolean b4 = circularQueue.deQueue();// 返回true
        System.out.println(b4);

        boolean b5 = circularQueue.enQueue(4);// 返回true
        System.out.println(b5);


        int rear1 = circularQueue.Rear();// 返回4
        System.out.println(rear1);*/

    }

}
