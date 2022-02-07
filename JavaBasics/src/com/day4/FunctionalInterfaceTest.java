package com.day4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 四大函数式接口：
 *
 * 消费型：void accept(T t)
 *
 * 供给型： T get()
 *
 * 函数型：R supply(T t)
 *
 * 断定型： boolean test(T t)
 */
public class FunctionalInterfaceTest {
    @Test
    public void test1(){
    happyTime(
        500,
        new Consumer<Double>() {
          @Override
          public void accept(Double aDouble) {
            System.out.println("The money is: "+ aDouble);
          }
        });
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("GoodCat","badCat","Dog","goodDog");
        List<String> filterStr = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("Cat");
            }
        });
    System.out.println(filterStr);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
