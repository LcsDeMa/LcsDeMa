package com.qf.demo1;

/**
 * @Auther: Lcs
 * @Date: 2020/7/15 19:27
 * @Description:
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Lambada的标准格式：
 *      （参数列表） -> {
 *
 *      }
 *      （参数列表）:参数列表
 *      ->:无实际含义，起到连接的作用
 *      {}：方法体
 *      练习有参有返回值的Lambda
 */
public class Demo01LambdaUse {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华",58,742));
        persons.add(new Person("张学友",48,182));
        persons.add(new Person("巩俐",68,152));
      /*  //降序
        Collections.sort(persons,( o1,o2)->{
            return o2.getAge() - o1.getAge();
        });*/
        //升序
        Collections.sort(persons,( o1,o2)->{
            return o1.getAge() - o2.getAge();
        });

        persons.forEach(person -> {
            System.out.println(person);
        });
        persons.forEach(person ->
            System.out.println(person)
        );
    }

}
