package com.dytian.nio.buffer;

import java.nio.CharBuffer;

public class BufferTest2 {

    public static void main(String[] args) {

        String content  = "你好! java NIO-Blocking.";
        CharBuffer charBuffer = CharBuffer.allocate(50);

        for (int i = 0;i < content.length();i++){
            charBuffer.put(content.charAt(i));
        }

        // 反转buffer 准备读取 buffer内容
        charBuffer.flip();
        while (charBuffer.hasRemaining()){
            System.out.print(charBuffer.get());
        }

        // 倒回读取之前 准备再次读取
        charBuffer.rewind();
        System.out.println();

        while (charBuffer.hasRemaining()){
            System.out.print(charBuffer.get());
        }

        System.out.println();

        // 清空buffer 复位 position buffer 可以再次复用
        charBuffer.clear();
        charBuffer.put('你').put('好').put('!');
        charBuffer.flip();

        //再次读取 buffer 里面的数据
        while (charBuffer.hasRemaining()){
            System.out.print(charBuffer.get());
        }


    }

}
