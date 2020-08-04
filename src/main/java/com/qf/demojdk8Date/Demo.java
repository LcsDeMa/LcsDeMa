package com.qf.demojdk8Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Auther: Lcs
 * @Date: 2020/7/18 17:10
 * @Description:
 */
public class Demo {
    @Test
    public void testLocalDate() throws ParseException {
//        Date now = new Date(1985,9,23);//时间加上了1900 Fri Oct 23 00:00:00 CST 3885
//        System.out.println(now);
//        2.时间格式化和解析时线程不安全的
//        Date parse = new SimpleDateFormat("yyyy-mm-dd").parse("2019-09-09");
//        System.out.println(parse);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    System.out.println(new SimpleDateFormat("yyyy-mm-dd").parse("2019-09-09"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    @Test
    public void test(){
        for (int i = 0; i < 6; i++) {
            System.out.println(i);
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date parse = dateFormat.parse("2019-09-09");
                    System.out.println(parse);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    @Test
    public void testLocalDate1(){
        LocalDate now = LocalDate.now();
        System.out.println(now);//2020-07-18
        //2018-08-08
        System.out.println(LocalDate.of(2018, 8, 8));
    }
    @Test
    public void testLocalTime(){
        LocalTime now = LocalTime.now();
        System.out.println(now);//17:46:24.834
    }
    @Test
    public void testLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2020-07-18T17:44:44.801
    }
    @Test
    public void test02(){
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dft = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(now.format(dft));
    }
    @Test
    public void testLocalDateTime2(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = now.withYear(9012);
        System.out.println(dateTime);
        System.out.println((now == dateTime));
        System.out.println(now.plusYears(2));
        System.out.println(now.minusYears(10));
    }
    @Test
    public void testEquals(){
        LocalDateTime dateTime = LocalDateTime.of(2018, 7, 12, 13,12);

        LocalDateTime now = LocalDateTime.now();
        boolean equal = now.isEqual(dateTime);
        System.out.println(equal);
        System.out.println(now.isAfter(dateTime));
        System.out.println(now.isBefore(dateTime));
    }
    //时间戳
    @Test
    public void test07(){
        //Instant内部保存了秒和纳秒，一般不是给用户使用的
        Instant now = Instant.now();
        System.out.println(now);
    }

}
