package com.dytian.cache;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataObject {
    private final String data;

    private static int objectCounter = 0;

    private DataObject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DataObject{" + "data='" + data + '\'' + '}';
    }

    public static DataObject get(String data) {
        objectCounter++;
        System.out.println("Init DataObject#{} with '{}'"+objectCounter+"====="+data);

        return new DataObject(data+objectCounter);
    }
}