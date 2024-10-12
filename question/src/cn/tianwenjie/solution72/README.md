### 编辑距离(Edit Distance)

#### 题目描述

给你两个单词 `word1` 和 `word2`，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

- 插入一个字符
- 删除一个字符
- 替换一个字符

**示例1:**

```
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
```

**示例2:**

```
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
```

提示：

- `0 <= word1.length, word2.length <= 500`
- `word1` 和 `word2` 由小写英文字母组成

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
