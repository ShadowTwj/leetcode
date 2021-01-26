package cn.tianwenjie.solution72;


/**
 * 递归实现
 */
//public class Solution {
//  public int minDistance(String word1, String word2) {
//    int l1 = word1.length();
//    int l2 = word2.length();
//    if (l1 == 0 || l2 == 0) {
//      return Math.max(l1, l2);
//    }
//
//    if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
//      return minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1));
//    }
//
//    return 1 + Math.min(minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1)), Math.min(minDistance(word1, word2.substring(0, l2 -
//      1)), minDistance(word1.substring(0, l1 - 1), word2)));
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.minDistance("house", "ros"));
//    System.out.println(solution.minDistance("intention", "execution"));
//  }
//}


/**
 * 自底向上
 * 动态规划实现
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

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minDistance("house", "ros"));
    System.out.println(solution.minDistance("intention", "execution"));
  }
}
