package com.qf.demoStream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Auther: Lcs
 * @Date: 2020/7/15 21:57
 * @Description:
 */
public class Demo02StreamNotice {
    public static void main(String[] args) {
        //调用stream中的静态方法of获取流
        Stream<String> stream5 = Stream.of("aa", "bb", "cc");
//        long count = stream5.count();
//        System.out.println(count);
//        Stream<String> limit = stream5.limit(1);
//        System.out.println("stream5" + stream5);
//        System.out.println("limit" + limit);

        System.out.println(stream5.filter((s) -> {
            System.out.println(s);
            return true;
        }).count());

    }

    @Test
    public void testForEach(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one,"迪丽热巴","jack","tom","jerry");

        one.stream().forEach(s -> {
            System.out.println(s);
        });
        one.stream().forEach(System.out::println);
    }
    @Test
    public void testMap(){
        Stream<String> stream = Stream.of("11", "22", "33");
//        stream.map(s-> Integer.parseInt(s)).forEach(System.out::println);
        stream.map(Integer::parseInt).forEach(System.out::println);
    }
    @Test
    public void testSorted(){
        Stream<Integer> stream = Stream.of(11, 22, 3);
//        stream.sorted().forEach(System.out::println);
        System.out.println("------------------");
        stream.sorted((o1, o2) -> o2-o1).forEach(System.out::println);

    }
    @Test
    public void testDistinct(){
        Stream<Integer> stream = Stream.of(11, 22, 3,22);
        stream.distinct().forEach(System.out::println);
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 13));
        list.add(new Person("jack", 13));
        list.add(new Person("tom", 13));
        list.add(new Person("jerry", 13));
        list.add(new Person("jerry", 13));
        list.stream().distinct().forEach(System.out::println);
        Stream<Person> stream1 = Stream.of(new Person("jack", 13),
                new Person("jack", 13),
                new Person("tom", 13),
                new Person("jerry", 13),
                new Person("jerry", 13));
        stream1.distinct().forEach(System.out::println);
    }
    @Test
    public void testmatch(){
        Stream<Integer> stream = Stream.of(5, 93, 4, 3, 5);
//        System.out.println(stream.allMatch(s -> s > 7));
//        System.out.println(stream.anyMatch(s -> s > 7));
        System.out.println(stream.noneMatch(s -> s > 7));
    }
    @Test
    public void testfind(){
        Stream<Integer> stream = Stream.of(5, 93, 4, 3, 5);
//        Optional<Integer> first = stream.findFirst();
//        System.out.println(first.get());
        System.out.println(stream.findAny().get());
    }
    @Test
    public void testMax_Min(){
//        System.out.println(Stream.of(5, 454, 8, 5, 6, 1, 8).max((o1, o2) -> o1 - o2).get());
//        Stream.of(5, 454, 8, 5, 6, 1, 8).distinct().sorted((o1, o2) -> o1-o2).forEach(System.out::println);
        System.out.println(Stream.of(5, 454, 8, 5, 6, 1, 8).min((o1, o2) -> o1 - o2).get());

    }
    @Test
    public void testReduce(){
        Stream<Integer> stream = Stream.of(5, 454, 8, 5, 6, 1, 8);
//        System.out.println(stream.reduce(0, ( x, y) ->{
//            System.out.println("x: "+x+" y: "+y);
//            return x + y;
//        }));
        System.out.println(stream.reduce(0, ( x, y) ->
             x > y ? x:y
        ));

    }
    @Test
    public void testMapReduce(){
//        System.out.println(
//                Stream.of(
//                new Person("jack", 13),
//                new Person("jack", 13),
//                new Person("tom", 13),
//                new Person("jerry", 13),
//                new Person("jerry", 13))
//                .map(p -> p.getAge())
//                .reduce(0, Integer::sum));
//
//        System.out.println(Stream.of(new Person("jack", 15),
//                new Person("jack", 13),
//                new Person("tom", 18),
//                new Person("jerry", 83),
//                new Person("jerry", 23)).max((o1, o2) ->
//                o1.getAge() - o2.getAge()
//        ).get());
        Integer reduce = Stream.of(new Person("jack", 13),
                new Person("jack", 23),
                new Person("tom", 33),
                new Person("jerry", 43),
                new Person("jerry", 53)).map(p -> p.getAge()).reduce(
                0, (x, y) -> x > y ? x : y
        );
        System.out.println(reduce);
    }
    @Test
    public void testDemo5(){
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");  one.add("宋远桥");  one.add("苏星河");  one.add("老子");  one.add("庄子");  one.add("孙子");  one.add("洪七公");
        List<String> two = new ArrayList<>();
        two.add("古力娜扎"); two.add("张无忌"); two.add("张三丰"); two.add("赵丽颖"); two.add("张三"); two.add("张二狗"); two.add("张天爱");
        Stream<String> stream1 = one.stream()
                .filter(s -> s.length() == 3)
                .limit(3);
        Stream<String> stream2 = two.stream()
                .filter(s -> s.startsWith("张"))
                .skip(2);
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.map(Person2::new).forEach(System.out::println);

    }
}
