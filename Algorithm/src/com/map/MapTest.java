package com.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
  public static void main(String[] args) {
    //
    var cf = new Charfinder();
    var result = cf.findFirstNonRepeatingChar("green");
    System.out.println(result);
  }
}

class Charfinder {
  public char findFirstNonRepeatingChar(String str) {

    var chars = str.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (var ch : chars) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    for (var ch : chars) {
      if (map.get(ch) == 1) {
        return ch;
      }
    }
    return Character.MIN_VALUE;
  }
}
