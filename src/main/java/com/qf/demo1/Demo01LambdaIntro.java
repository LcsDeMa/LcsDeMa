package com.qf.demo1;

/**
 * @Auther: Lcs
 * @Date: 2020/7/15 19:27
 * @Description:
 */
public class Demo01LambdaIntro {
    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行");
            }
        }).start();
        new Thread(()->{
            System.out.println("Lambda执行");
        }).start();
    }
}
