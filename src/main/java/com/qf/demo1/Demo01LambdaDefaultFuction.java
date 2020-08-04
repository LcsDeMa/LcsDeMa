package com.qf.demo1;

/**
 * @Auther: Lcs
 * @Date: 2020/7/15 20:26
 * @Description:
 */
public class Demo01LambdaDefaultFuction {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.test01();
        CC cc = new CC();
        cc.test01();

    }
}
interface AA{
    public default void test01(){
        System.out.println("默认方法");
    }
}
//接口中的默认方法实现类可以直接调用

class BB implements AA{

}
class CC implements AA{
    @Override
    public void test01() {
        System.out.println("重写默认方法");
    }
}
