package io.loustler.massemble.leetcode;

import java.util.*;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
  final static Map<Character, Character> Table = new HashMap<>(3);

  static {
    Table.put(']', '[');
    Table.put('}', '{');
    Table.put(')', '(');
  }

  public static void main(String[] args) {
    System.out.println(solve("()")); // true
    System.out.println(solve("()[]{}")); // true
    System.out.println(solve("(]")); // false
    System.out.println(solve("([)]")); // false
    System.out.println(solve("{[]}")); // true
  }

  public static boolean solve(String s) {
    final Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Table.containsKey(c)) {
        char recent = stack.isEmpty() ? '?' : stack.pop();

        if (recent != Table.get(c)) return false;
      } else stack.push(c);
    }

    return stack.isEmpty();
  }
}
