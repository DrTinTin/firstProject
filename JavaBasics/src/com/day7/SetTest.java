package com.day7;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * HashSet: 主要实现类；可以存null
 *
 * <p>LinkedHashSet: HashSet的子类，遍历数据时可以按照添加的顺序遍历
 *
 * <p>TreeSet: 可以对元素进行排序
 */
public class SetTest {
  @Test
  public void test() {
    var treeSet = new TreeSet<String>();
    treeSet.add("123");
    treeSet.add("22");
    treeSet.add("12");
    for (var str : treeSet) {
      System.out.println(str);
    }
  }

  @Test
  public void test2() {
    var treeSet = new TreeSet<String>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
      }
    });
    treeSet.add("123");
    treeSet.add("22");
    treeSet.add("12");
    for (var str : treeSet) {
      System.out.println(str);
    }
  }
}
