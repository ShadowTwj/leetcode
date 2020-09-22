package cn.tianwenjie.solution70;


/**
 * 递归实现(会超时)
 */
//public class Solution {
//  public int climbStairs(int n) {
//    return climbStairs(n, 0);
//  }
//
//  private int climbStairs(int n, int step) {
//    if (n < step) {
//      return 0;
//    }
//    if (n == step) {
//      return 1;
//    }
//
//    return climbStairs(n, step + 1) + climbStairs(n, step + 2);
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.climbStairs(2));
//    System.out.println(solution.climbStairs(3));
//  }
//}


/**
 * 动态规划实现
 */
public class Solution {
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

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.climbStairs(2));
    System.out.println(solution.climbStairs(3));
  }
}
