package com.dytian.image.compress;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

public class ImageUtils {


    public static void main(String[] args) throws IOException {


        Thumbnails.of("D:\\1111.jpg")
                .scale(1f)
                .outputQuality(0.5f)
                .toFile("D:\\2222.jpg");

    }

}
