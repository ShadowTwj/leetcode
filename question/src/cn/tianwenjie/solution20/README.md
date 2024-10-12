### 有效的括号(Merge Two Sorted Lists)

#### 题目描述

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。

**示例1:**

```
输入: "()"
输出: true
```

**示例2:**

```
输入: "()[]{}"
输出: true
```

**示例3:**

```
输入: "(]"
输出: false
```

**示例4:**

```
输入: "([)]"
输出: false
```

**示例5:**

```
输入: "{[]}"
输出: true
```

#### 题解

- 栈实现

```java
class Solution {
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
}
```
