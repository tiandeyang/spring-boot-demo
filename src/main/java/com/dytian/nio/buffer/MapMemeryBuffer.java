package com.dytian.nio.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MapMemeryBuffer {

     public static void main(String[] args) throws Exception {

       MapMemeryBuffer.TestInBound();


     }


    public static void transferAndSaveFile() throws Exception {

       ByteBuffer byteBuf = ByteBuffer.allocate(1024 * 14 * 1024);
       byte[] bbb = new byte[14 * 1024 * 1024];
       FileInputStream fis = new FileInputStream("D:\\weixin.war");
       FileOutputStream fos = new FileOutputStream("D:\\target.txt");
       FileChannel fc = fis.getChannel();
       long timeStar = System.currentTimeMillis();// 得到当前的时间
       //   fc.read(byteBuf);// 1 读取
       MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
       System.out.println(fc.size()/1024);
       long timeEnd = System.currentTimeMillis();// 得到当前的时间
       System.out.println("Read time :" + (timeEnd - timeStar) + "ms");
       timeStar = System.currentTimeMillis();
       //     fos.write(bbb);//2.写入
       mbb.flip();
       timeEnd = System.currentTimeMillis();
       System.out.println("Write time :" + (timeEnd - timeStar) + "ms");
       fos.flush();
       fc.close();
       fis.close();

    }



    public static void TestInBound() throws IOException {

     int length = 0x8FFFFFF;//一个byte占1B，所以共向文件中存128M的数据
     try (FileChannel channel = FileChannel.open(Paths.get("D:\\target.txt"),
             StandardOpenOption.READ, StandardOpenOption.WRITE);) {
      MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);

      int capacity = mapBuffer.capacity();
      System.out.println("capacity===="+capacity);
      Buffer clear = mapBuffer.clear();



//      for(int i=0;i<length;i++) {
//       mapBuffer.put((byte)0);
//      }
//      for(int i = length/2;i<length/2+4;i++) {
//       //像数组一样访问
//       System.out.println(mapBuffer.get(i));
//      }

     }




    }


}