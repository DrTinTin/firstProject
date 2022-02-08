package com.day7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * HashMap can store null key and value
 *
 * <p>A map has no iterator
 */
public class MapTest {
  @Test
  public void test() {
    var map = new HashMap<Integer, Integer>();
    var map1 = new HashMap<Integer, Integer>();
    map.put(null, 123);
    map.getOrDefault(0, 1);
    map1.putAll(map);
    map.containsKey(123);
    map.containsValue(123);
    var keys = map.keySet();
    for (var key : keys){
      System.out.println(key);
    }
    var coll = map.values();
    for (var obj : coll){
      System.out.println(obj);
    }

    Set entrySet = map.entrySet();
    for (var obj : entrySet){
      Map.Entry<Integer, Integer> entry = (Map.Entry<Integer,Integer>) obj;
      entry.getKey();
      entry.getValue();
    }
    System.out.println(map);
    var tmap =
        new TreeMap<Integer, Integer>(
            new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
              }
            });
    tmap.put(1, 2);
    tmap.put(2, 2);
    tmap.put(3, 2);
    tmap.put(0, 2);
    System.out.println(tmap);
    tmap.clear();
  }
}
