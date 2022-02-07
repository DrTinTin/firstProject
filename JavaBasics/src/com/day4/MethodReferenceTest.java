package com.day4;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * 当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用；
 *
 *方法引用是函数式接口的实例
 */
public class MethodReferenceTest {
    @Test
    public  void test1(){
        // 对象::实例方法
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("Singapore");
        var ps = System.out;
        Consumer<String> con2 = ps::println;
    }
}
