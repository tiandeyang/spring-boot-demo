package com.dytian.collections.list;

import com.dytian.entity.User_account;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListTest {


    public static void main(String[] args) {
        // 写时复制
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        // 添加数据时 加锁；并将数据 复制到一个新数组里面
        strings.add("aa");
        strings.get(0);
        CopyOnWriteArraySet<User_account> user_accounts = new CopyOnWriteArraySet<>();
        user_accounts.add(null);
    }

    static class UnitTest{

    }


}
