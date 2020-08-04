package com.qf.demoAnnotation;

import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Auther: Lcs
 * @Date: 2020/7/18 20:10
 * @Description:
 */
@Mytest("ta")
@Mytest("tb")
@Mytest("tc")
public class Demo1 {
    @Test
    @Mytest("ma")
    @Mytest("mb")
    public void test(){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        //解析重复注解
        //getAnnotationsByType是新增的api用户获取重复的注解
        Mytest[] annotationsByType = Demo1.class.getAnnotationsByType(Mytest.class);
        for (Mytest mytest: annotationsByType) {
            System.out.println(mytest);
        }
        Mytest[] tests = Demo1.class.getMethod("test").getAnnotationsByType(Mytest.class);
        for (Mytest mytest:tests) {
            System.out.println(mytest);
        }
    }
}
//1.定义重复的注解容器注解
@Retention(RetentionPolicy.RUNTIME)
@interface Mytests{
    Mytest[] value();
}

//2.定义一个可以重复的注解
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Mytests.class)
@interface Mytest{
    String value();
}