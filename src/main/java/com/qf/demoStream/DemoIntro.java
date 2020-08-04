package com.qf.demoStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Lcs
 * @Date: 2020/7/15 21:57
 * @Description:
 */
public class DemoIntro {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"jack","lina","jerry","jiej");
        list.stream().filter(s->{
           return s.startsWith("j");
        })
        .filter(s->{
         return  s.length() == 4;})
        .forEach(s -> {
            System.out.println(s);
        });
    }
}
