### 反转字符串(Reverse String)

#### 题目描述

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组`char[]`的形式给出。

不要给另外的数组分配额外的空间，你必须原地**修改输入数组**、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

**示例1:**

```
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```

**示例2:**

```
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
```

#### 题解

```java
public class Solution {
 public void reverseString(char[] s) {
     int n = s.length;
     for (int i = 0; i < n / 2; i++) {
       if (s[i] != s[n - 1 - i]) {
         char temp = s[i];
         s[i] = s[n - 1 - i];
         s[n - 1 - i] = temp;
       }
     }
 }
}
```
