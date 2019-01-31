package com.dytian.image.compress;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

public class ImageUtils {



    /**
     *
     * @param args
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {

//        Thumbnails.of("D:\\jidan.png")
//                .scale(1f)
//                .outputQuality(0.5f)
//                .toFile("D:\\jidan2.png");


        Thumbnails.of("D:\\jidan.png").scale(1f).outputFormat("jpg").toFile("D:\\jidan4.jpg");


    }

}
