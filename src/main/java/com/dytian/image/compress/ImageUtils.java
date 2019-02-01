package com.dytian.image.compress;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageUtils {



    /**
     *
     * @param args
     * @throws IOException
     */




    public static void main(String[] args) throws IOException {


//        Thumbnails.of("D:\\logo.jpg")
//                .scale(1f)
//                .outputQuality(0.5f)
//                .toFile("D:\\logo.jpg");

    //    Thumbnails.of("D:\\jidan.png").scale(1f).outputFormat("jpg").toFile("D:\\jidan4.jpg");


        //  同样的商品图片 一张有水印 一张没有水印 消费者会选择哪个商品下单
        Thumbnails.of("D:\\my.jpg").scale(1f).watermark(Positions.CENTER, ImageIO.read(new File("D:\\share.png")), 0.3f)
                .outputQuality(0.8f).toFile("D:\\logo_with_watermark5.jpg");



    }

}
