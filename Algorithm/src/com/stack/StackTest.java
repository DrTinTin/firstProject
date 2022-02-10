package com.stack;

import java.util.Stack;

public class StackTest {
  public static void main(String[] args) {
    //
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack.search(4));
    System.out.println(reverse("abcd"));
    BalancedExpression bd = new BalancedExpression();
    System.out.println(bd.isBalanced("(1+3)"));
  }

  public static String reverse(String input) {
    Stack<Character> stack = new Stack<>();
    for (char ch : input.toCharArray()) {
      stack.push(ch);
}
    StringBuilder reversed = new StringBuilder();
    while (!stack.isEmpty()) {
      reversed.append(stack.pop());
    }
    return reversed.toString();
  }
}
