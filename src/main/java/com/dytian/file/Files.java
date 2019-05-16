package com.dytian.file;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Files {

    public static void main(String[] args) throws IOException {



        File fileDectory = new File("D:\\阅米UI\\纤姿洁\\花舞飞扬系列\\1本色通用详情\\");

        Collection<File> files = FileUtils.listFiles(fileDectory, null, false);
        for (File file:files){
        //    FileUtils.moveFileToDirectory(file,new File("D:\\test"),true);
         //   FileUtils.copyFileToDirectory(file,new File("D:\\test"),true);
            file.renameTo(new File("D:\\test\\rename"+file.getName()));
        }
    }
}
