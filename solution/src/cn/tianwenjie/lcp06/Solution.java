package cn.tianwenjie.lcp06;

public class Solution {
  public int minCount(int[] coins) {
    int count = 0;
    for (int coin : coins) {
      count += coin / 2 + coin % 2;
    }
    return count;
  }
}
