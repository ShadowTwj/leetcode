### 爬楼梯(Climbing Stairs)

#### 题目描述
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

**注意：** 给定 n 是一个正整数。 

**示例1:**
```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

**示例2:**
```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

#### 题解
- 递归实现(会超时)
```java
class Solution {
  public int climbStairs(int n) {
      return climbStairs(n, 0);
    }
  
    private int climbStairs(int n, int step) {
      if (n < step) {
        return 0;
      }
      if (n == step) {
        return 1;
      }
  
      return climbStairs(n, step + 1) + climbStairs(n, step + 2);
  }
}
```

- 动态规划实现
```java
class Solution {
  public int climbStairs(int n) {
      if (n == 1) {
        return 1;
      }
      int[] dp = new int[n + 1];
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
  
      return dp[n];
  }
}
```
