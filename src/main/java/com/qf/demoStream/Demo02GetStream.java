package com.qf.demoStream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Auther: Lcs
 * @Date: 2020/7/15 21:57
 * @Description:
 */
public class Demo02GetStream {
    public static void main(String[] args) {
        //根据collection集合中的方法获取流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        Map<String,String> map = new HashMap<>();
        Stream<String> stream2 = map.keySet().stream();
        Stream<String> stream3 = map.values().stream();
        Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();

        //调用stream中的静态方法of获取流
        Stream<String> stream5 = Stream.of("aa", "bb", "cc");

        String[] strings = {"aa", "bb", "cc"};
        Stream<String> stream6 = Stream.of(strings);

    }
}
