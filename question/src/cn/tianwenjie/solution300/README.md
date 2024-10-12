### 最长递增子序列(Longest Increasing Subsequence)

#### 题目描述

给你一个整数数组 `nums` ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，`[3,6,2,7]` 是数组 `[0,3,1,6,2,2,7]` 的子序列。

**示例1:**

```
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
```

**示例2:**

```
输入：nums = [0,1,0,3,2,3]
输出：4
```

**示例3:**

```
输入：nums = [7,7,7,7,7,7,7]
输出：1
```

提示：

- `1 <= nums.length <= 2500`
- `-104 <= nums[i] <= 104`

进阶：

- 你可以设计时间复杂度为 `O(n2)` 的解决方案吗？
- 你能将算法的时间复杂度降低到 `O(n log(n))` 吗?

#### 题解

- 递归实现

```java
public class Solution {
  public int minDistance(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    if (l1 == 0 || l2 == 0) {
      return Math.max(l1, l2);
    }

    if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
      return minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1));
    }

    return 1 + Math.min(minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1)), Math.min(minDistance(word1, word2.substring(0, l2 -
      1)), minDistance(word1.substring(0, l1 - 1), word2)));
  }
}
```

- 动态规划

```java
/**
 * 自底向上
 */
public class Solution {
  public int minDistance(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    //初始化dp
    for (int i = 0; i <= l1; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= l2; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= l1; i++) {
      for (int j = 1; j <= l2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
        }
      }
    }

    return dp[l1][l2];
  }
}
```
