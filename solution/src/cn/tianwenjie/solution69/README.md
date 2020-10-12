### x 的平方根(Sqrt(x))

#### 题目描述
实现`int sqrt(int x)`函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
你能在线性时间复杂度内解决此题吗？

**示例1:**
```
输入: 4
输出: 2
```

**示例2:**
```
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
```

#### 题解
- 二分法实现(可能会超出时间范围)
```java
public class Solution {
  public int mySqrt(int x) {
      if (x < 2) {
        return x;
      }
      int left = 2;
      int right = x / 2;
      int mid;
      long num;
      while (left <= right) {
        mid = left + (right - left) / 2;
        num = mid * (long) mid;
        if (num < x) {
          left++;
        } else if (num > x) {
          right--;
        } else {
          return mid;
        }
      }
      return right;
  }
}
```

- 牛顿迭代实现
```java
public class Solution {
  public int mySqrt(int x) {
      if (x < 2) {
        return x;
      }
      double x0 = x;
      double x1 = (x0 + x / x0) / 2.0;
      while (Math.abs(x0 - x1) >= 1) {
        x0 = x1;
        x1 = (x0 + x / x0) / 2.0;
      }
      return (int) x1;
  }
}
```
