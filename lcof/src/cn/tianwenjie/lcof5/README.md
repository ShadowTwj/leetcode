### 替换空格

#### 题目描述
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

**示例:**
```
输入：s = "We are happy."
输出："We%20are%20happy."
```

**限制:**
`0 <= s 的长度 <= 10000`

#### 题解
- `StringBuild`实现
```java
public class Solution {
  public String replaceSpace(String s) {
    StringBuilder sb = new StringBuilder();
    for (Character c : s.toCharArray()) {
      if (c == ' ') {
        sb.append("%20");
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
```

- 数组实现
```java
class Solution {
  public String replaceSpace(String s) {
    int count = 0;
    for (Character c : s.toCharArray()) {
      if (c == ' ') {
        count++;
      }
    }
    char[] result = new char[s.length() + count * 2];
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        result[j++] = '%';
        result[j++] = '2';
        result[j++] = '0';
      } else {
        result[j++] = c;
      }
    }

    return new String(result);
  }
}
```
