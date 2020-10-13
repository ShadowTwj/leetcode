### 左旋转字符串

#### 题目描述
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

**示例1:**
```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
```

**示例2:**
```
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```

**限制:**
- 1 <= k < s.length <= 10000

#### 题解
- 切片实现
```java
public class Solution {
  public String reverseLeftWords(String s, int n) {
    return s.substring(n) + s.substring(0, n);
  }
}
```
- 遍历实现
```java
public class Solution {
  public String reverseLeftWords(String s, int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = n; i < n + s.length(); i++) {
      sb.append(s.charAt(i % s.length()));
    }
    return sb.toString();
  }
}

```
