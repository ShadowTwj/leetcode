package cn.tianwenjie.lcp07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  int result = 0;

  public int numWays(int n, int[][] relation, int k) {
    Map<Integer, List<Integer>> map = new HashMap<>(relation.length);
    for (int[] ints : relation) {
      map.computeIfAbsent(ints[0], key -> new ArrayList<>()).add(ints[1]);
    }

    dfs(n, map, 0, k);

    return result;
  }

  private void dfs(int n, Map<Integer, List<Integer>> map, int cur, int k) {
    if (k < 0) {
      return;
    }
    if (k == 0 && cur == n - 1) {
      result++;
      return;
    }

    List<Integer> list = map.get(cur);
    if (list == null) {
      return;
    }

    list.forEach(integer -> dfs(n, map, integer, k - 1));
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] array = new int[][] {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
    int[][] array1 = new int[][] {{0, 2}, {2, 1}};
    System.out.println(solution.numWays(5, array, 3));
    System.out.println(solution.numWays(3, array1, 2));
  }
}
