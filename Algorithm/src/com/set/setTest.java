package com.set;

import java.util.HashSet;
import java.util.Set;

public class setTest {
  public static void main(String[] args) {
    //
  }

  public static char findFirstRepeat(String str) {
    Set<Character> set = new HashSet<>();
    for (var ch : str.toCharArray()) {
      if (set.contains(ch)) {
        return ch;
      }
      set.add(ch);
    }
    return Character.MIN_VALUE;
  }
}
