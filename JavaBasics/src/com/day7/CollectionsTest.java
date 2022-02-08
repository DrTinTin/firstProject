package com.day7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest {
  @Test
  public void test() {
    var list = Arrays.asList(123, 123, 2343, 22, 12, 234);
    Collections.reverse(list);
    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return -o1.compareTo(o2);
      }
    });
    System.out.println(list);
    System.out.println(Collections.max(list));
  }
}
