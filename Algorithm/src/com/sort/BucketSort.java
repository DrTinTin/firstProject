package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
  private int hash(int i, int max, int numberOfBuckets) {
    return (int) ((double) i / max * (numberOfBuckets - 1));
  }

  private int findMax(List<Integer> input) {
    int m = Integer.MIN_VALUE;
    for (int i : input) {
      m = Math.max(i, m);
    }
    return m;
  }

  public List<Integer> sort(List<Integer> input) {
    int numBuckets = (int) Math.sqrt(input.size());
    List<List<Integer>> buckets = new ArrayList<>(numBuckets);
    for (int i = 0; i < numBuckets; i++) {
      buckets.add(new ArrayList<>());
    }
    int max = findMax(input);
    for (int i : input) {
      buckets.get(hash(i, max, numBuckets)).add(i);
    }
    for (var bucket : buckets) {
      Collections.sort(bucket);
    }
    List<Integer> sortedArray = new LinkedList<>();
    for (var bucket : buckets) {
      sortedArray.addAll(bucket);
    }
    return sortedArray;
  }
}
