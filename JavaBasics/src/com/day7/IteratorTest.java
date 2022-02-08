package com.day7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IteratorTest {
  @Test
  public void test() {
    var coll = Arrays.asList(123, 334, 556);
    var iterator = coll.iterator();
    while (iterator.hasNext()) {
      var obj = iterator.next();

    }
    System.out.println(coll.size());
  }
}
