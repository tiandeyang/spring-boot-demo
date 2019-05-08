package com.dytian.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderTest {

    public static void main(String[] args) throws IOException {

        String name = "java/sql/Array.class";
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(name);
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url.toString());
        }

    }


}
