package com.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection: 单列集合，用来存储一个一个的对象
 *
 * <p>|**List接口：有序，可重复的数据
 *
 * <p>|**Set:无序，不可重复的数据*
 */
public class CollectionTest {
  public static void main(String[] args) {
    //
    Collection coll = new ArrayList();
    Collection coll2 = new ArrayList();
    coll.add("AA");
    coll.add("AA");
    System.out.println(coll.size());
    coll2.add(123);
    coll2.add(9909);
    coll.addAll(coll2);
    System.out.println(coll.isEmpty());
    coll.contains(123);
    coll.remove(123); // 移除所有的123
    Collection coll3 = Arrays.asList(123, 234, 455);
    System.out.println(coll3.hashCode());
    Object[] arr = coll.toArray();
    var list2 = Arrays.asList(new Integer[]{1,2,3});
    System.out.println(list2);
  }
}
