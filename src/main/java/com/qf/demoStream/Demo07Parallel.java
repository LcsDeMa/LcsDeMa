package com.qf.demoStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Auther: Lcs
 * @Date: 2020/7/18 11:12
 * @Description:
 */
public class Demo07Parallel {
    private static final int times = 500000000;
    long start;
    @Before
    public void init(){
        start = System.currentTimeMillis();
    }
    @After
    public void destroy(){
        long end = System.currentTimeMillis()-start;
        System.out.println("消耗时间： "+end);
    }
    @Test
    public void testStream(){
        //553
        LongStream.rangeClosed(0,times).reduce(0,Long::sum);
    }
    @Test
    public void testParallelStream(){
//        ArrayList<Integer> list = new ArrayList<>();
//        IntStream.rangeClosed(1,1000)
//                .parallel()
//                .forEach(i -> {
//                    synchronized (this) {
//                        list.add(i);
//                    }
//                });

        //448

        //解决paralleStream线程安全问题方案一：使用线程安全的集合
        Vector<Integer> v = new Vector();
        IntStream.rangeClosed(0,1000)
                .parallel()
                .forEach(s->
                        v.add(s));
        System.out.println("list = " + v.size());
    }
    @Test
    public void testFor(){
        //255
        int sum = 0;
        for (int i = 0; i < times; i++) {
            sum += i;
        }
    }
    @Test
    public void testParallel(){
        Stream.of(4,5,3,9,1,2,6)
                .parallel()
                .filter(s->
                {
                    System.out.println(Thread.currentThread() + "::" + s);
                    return s>3;
                }).count();
    }
    @Test
    public void testgetParallelStream(){
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.parallelStream();

        Stream<String> parallel = list.stream().parallel();
    }
    @Test
    public void test0Serial(){
        Stream.of(4,5,3,9,1,2,6)
                .filter(s->{
                    System.out.println(Thread.currentThread().getName());
                    return s>3;
                }).count();
    }
    @Test
    public void testParallel2(){
        List<Integer> collect = IntStream.rangeClosed(1, 1000)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void testParallel3(){
        LongStream.rangeClosed(1, 1000)
                .parallel()
                .reduce(Long::sum);

    }
    @Test
    public void tsetOption(){
        Optional<String> op2 = Optional.ofNullable("如花");
    }
}
