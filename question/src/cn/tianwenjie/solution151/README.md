### 翻转字符串里的单词(Reverse Words in a String)

#### 题目描述

给定一个字符串，逐个翻转字符串中的每个单词。

**示例1:**

```
输入: "the sky is blue"
输出: "blue is sky the"
```

**示例2:**

```
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

**示例3:**

```
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

**说明：**

- 无空格字符构成一个单词。
- 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
- 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

#### 题解

- api实现

```java
class Solution {
  public String reverseWords(String s) {
      s = s.trim();
      List<String> words = Arrays.asList(s.split("\\s+"));
      Collections.reverse(words);
      return String.join(" ", words);
  }
}
```

- 双指针实现

```java
class Solution {
  public String reverseWords(String s) {
      int start = s.length(), end = start;
      StringBuilder result = new StringBuilder();
      for (int i = start - 1; i >= 0; i--) {
        if (s.charAt(i) == ' ') {
          if (start != end) {
            result.append(s, start, end).append(' ');
            start = i + 1;
            end = start;
          }
          end--;
          start--;
        } else {
          start--;
        }
      }
      if (result.length() > 0 && start == end) {
        result.setLength(result.length() - 1);
      } else {
        result.append(s, start, end);
      }
  
      return result.toString();
  }
}
```

- 栈实现列实现

```java
class Solution {
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
}
```
