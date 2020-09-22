package cn.tianwenjie.solution20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 栈实现
 */
public class Solution {
  private Map<Character, Character> mapping = new HashMap<>();

  public Solution() {
    mapping.put('(', ')');
    mapping.put('[', ']');
    mapping.put('{', '}');
  }

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (mapping.containsKey(c)) {
        stack.push(c);
      } else if (!c.equals(mapping.get(stack.isEmpty() ? '#' : stack.pop()))) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isValid("()"));
    System.out.println(solution.isValid("()[]{}"));
    System.out.println(solution.isValid("(]"));
    System.out.println(solution.isValid("([)]"));
    System.out.println(solution.isValid("{[]}"));
  }
}
