package cn.tianwenjie.solution151;


import java.util.Stack;


/**
 * api实现
 */
//public class Solution {
//  public String reverseWords(String s) {
//    s = s.trim();
//    List<String> words = Arrays.asList(s.split("\\s+"));
//    Collections.reverse(words);
//    return String.join(" ", words);
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.reverseWords("the sky is blue"));
//    System.out.println(solution.reverseWords("  hello world!  "));
//    System.out.println(solution.reverseWords("a good   example"));
//  }
//}


/**
 * 双指针实现
 */
//public class Solution {
//  public String reverseWords(String s) {
//    int start = s.length(), end = start;
//    StringBuilder result = new StringBuilder();
//    for (int i = start - 1; i >= 0; i--) {
//      if (s.charAt(i) == ' ') {
//        if (start != end) {
//          result.append(s, start, end).append(' ');
//          start = i + 1;
//          end = start;
//        }
//        end--;
//        start--;
//      } else {
//        start--;
//      }
//    }
//    if (result.length() > 0 && start == end) {
//      result.setLength(result.length() - 1);
//    } else {
//      result.append(s, start, end);
//    }
//
//    return result.toString();
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.reverseWords("the sky is blue"));
//    System.out.println(solution.reverseWords("  hello world!  "));
//    System.out.println(solution.reverseWords("a good   example"));
//  }
//}


/**
 * 栈实现
 */
public class Solution {
  public String reverseWords(String s) {
    StringBuilder word = new StringBuilder();
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != ' ') {
        word.append(c);
      } else if (word.length() != 0) {
        stack.push(word.toString());
        word.setLength(0);
      }
    }
    if (word.length() != 0) {
      stack.push(word.toString());
      word.setLength(0);
    }
    while (!stack.isEmpty()) {
      word.append(stack.pop()).append(" ");
    }
    if (word.length() != 0) {
      word.setLength(word.length() - 1);
    }

    return word.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverseWords("the sky is blue"));
    System.out.println(solution.reverseWords("  hello world!  "));
    System.out.println(solution.reverseWords("a good   example"));
    System.out.println(solution.reverseWords(""));
    System.out.println(solution.reverseWords(" "));
    System.out.println(solution.reverseWords("  "));
  }
}
