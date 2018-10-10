package com.dytian.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("capacity=="+buffer.capacity());
        System.out.println("limit==="+buffer.limit());
        System.out.println("position==="+buffer.position());
        System.out.println("remainning===="+buffer.remaining());

        buffer.limit(6);

        System.out.println("limit==="+buffer.limit());
        System.out.println("position==="+buffer.position());
        System.out.println("remainning===="+buffer.remaining());

        buffer.position(2);

        System.out.println("position==="+buffer.position());
        System.out.println("remainning===="+buffer.remaining());

        System.out.println(buffer);






    }

}
