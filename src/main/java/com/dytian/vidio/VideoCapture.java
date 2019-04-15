package com.dytian.vidio;

import org.bytedeco.javacv.FFmpegFrameGrabber;

import javax.imageio.ImageIO;


import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Frame;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;

public class VideoCapture {

    /**
     * 获取指定视频的帧并保存为图片至指定目录
     *
     * @param videofile 源视频文件路径
     * @param prepath 截取帧的图片存放路径
     * @throws Exception
     */
    public static String fetchFrame(String videofile,String prepath)
            throws Exception {
        long start = System.currentTimeMillis();
        // File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        StringBuilder builder = new StringBuilder();
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
//            if ((i > 15) && (f.image != null)) {
//                break;
//            }
            if (i % 5 == 0 && (f.image != null)){
                String targetPath = prepath + LocalTime.now().getNano() + ".jpg";
                builder.append(targetPath+";");
                System.out.println("i=="+i);
                pictureByFrame(new File(targetPath), f);
            }
            if (i > 30){
                System.out.println("i=============="+i);
                break;
            }
            i++;
        }
     //   pictureByFrame(targetFile, ff, f);
        ff.stop();
        String s = builder.toString();
        System.out.println(System.currentTimeMillis() - start);
        return s.substring(0,s.length()-1);

    }

    private static void pictureByFrame(File targetFile, Frame f) throws IOException {
        IplImage img = f.image;
        int owidth = img.width();
        int oheight = img.height();
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(f.image.getBufferedImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
     //   ff.stop();
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            String s = VideoCapture.fetchFrame("D:\\xq.mp4", "D:\\capture\\");
            System.out.println("保存路径为:"+s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now().toSecondOfDay());

//        System.out.println(URLEncoder.encode("sku_name:手机&rows=3&sort=ng_price desc,stock asc&start=0","utf-8"));
//
//        Response response = Http.get("http://select.yuemee.com:8983/solr/yuemee_solr/select?q=sku_name:%E6%89%8B%E6%9C%BA&rows=3&sort=ng_price%20desc,stock%20asc&start=1");
//        System.out.println(response.getContent());


    }

}