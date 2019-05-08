package com.dytian.nio.buffer;

import com.sun.org.apache.xpath.internal.operations.String;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;

public class BufferTest {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put("t".getBytes());
        byte b = buffer.get();
        System.out.println(b);



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
