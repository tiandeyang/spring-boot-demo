package com.dytian.lamada;

import com.dytian.entity.User_account;
import org.nutz.json.Json;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname LamadaTest
 * @Description TODO
 * @Date 2019/4/22 16:28
 * @Created by Administrator
 */
public class LamadaTest {

    /**
     * 防空利器
     */
    public void optionalEmpty(){

        List<User_account> user_accounts = new ArrayList<>();
        user_accounts.add(new User_account().setUser_id(1).setUser_name("test1"));
        user_accounts.add(new User_account().setUser_id(2).setUser_name("test2"));
        user_accounts.add(new User_account().setUser_id(3).setUser_name("test3"));
        user_accounts.add(null);

        Optional.ofNullable(user_accounts).orElse(Collections.emptyList())
                .forEach(System.out::println);


        // filter 过滤null

        user_accounts.stream().filter(Objects::nonNull).forEach(
                f->{System.out.println(f.getUser_name());}
        );


        // 集合变形 业务中很常见
        List<String> names = user_accounts.stream().filter(Objects::nonNull).map(
                User_account::getUser_name
        ).collect(Collectors.toList());
        for (String name : names) {
            System.out.println("name==="+name);
        }

        // list 转 map
        Map<String, User_account> maps = user_accounts.stream().filter(Objects::nonNull).collect(
                Collectors.toMap(User_account::getUser_name, s -> s)
        );
        System.out.println(Json.toJson(maps));
    }


    public static void main(String[] args) {
        LamadaTest lamadaTest = new LamadaTest();
        lamadaTest.optionalEmpty();

    }

}
