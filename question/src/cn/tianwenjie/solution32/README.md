### 最长有效括号(Longest Valid Parentheses)

#### 题目描述

给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

**示例1:**

```
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
```

**示例2:**

```
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
```

#### 题解

- 栈实现

```java
class Solution {
  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();

    int max = 0;
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ('(' == c) {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          max = Math.max(max, i - stack.peek());
        }
      }
    }
    return max;
  }
}
```

- 动态规划实现

```java
class Solution {
  public int longestValidParentheses(String s) {
      int max = 0;
      int[] dp = new int[s.length()];
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == ')') {
          if (s.charAt(i - 1) == '(') {
            dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
          } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
            dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
          }
          max = Math.max(max, dp[i]);
        }
      }
      return max;
  }
}
```
