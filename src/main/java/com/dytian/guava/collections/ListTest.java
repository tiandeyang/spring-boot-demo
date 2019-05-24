package com.dytian.guava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import org.nutz.json.Json;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @Classname ListTest
 * @Description TODO
 * @Date 2019/5/24 10:36
 * @Created by Administrator
 */
public class ListTest {


    public static void main(String[] args) {
        // 不可变集合
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello2");
        list.add("hello3");

        ImmutableList<String> im = ImmutableList.<String>copyOf(list);
        ImmutableList<String> of = ImmutableList.<String>of("t", "d", "t", "a", "t", "c");
        System.out.println(Json.toJson(of));

        // 视图

        HashMultiset<String> hset = HashMultiset.create();

        hset.add("tdyatc");
        hset.add("tdyatc");
        hset.add("hello");

        Iterator<String> iterator = hset.iterator();
        Set<Multiset.Entry<String>> entries = hset.entrySet();
        System.out.println(hset.count("tdyatc"));

        //Multimap接口  很容易把一个键映射到多个值
        ArrayListMultimap<String, Integer> asm=ArrayListMultimap.create();
        List<Integer> arr=Arrays.asList(1,2,3,4,5,6);
        // putAll(String key,Iterable<? extends V> values)
        asm.putAll("zhaotong", arr);
        asm.put("zhaotong", 7);
        asm.put("zhaoritian", 9999);

        asm.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String t, Integer u) {
                System.out.println(t+" "+u);
            }
        });
        System.out.println(asm.get("zhaotong"));






    }

}
