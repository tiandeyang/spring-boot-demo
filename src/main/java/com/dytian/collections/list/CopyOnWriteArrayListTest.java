package com.dytian.collections.list;

import com.dytian.entity.User_account;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListTest {


    public static void main(String[] args) {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        strings.add("aa");
        strings.get(0);

        CopyOnWriteArraySet<User_account> user_accounts = new CopyOnWriteArraySet<>();
        user_accounts.add(null);
    }


    static class UnitTest{




    }


}
