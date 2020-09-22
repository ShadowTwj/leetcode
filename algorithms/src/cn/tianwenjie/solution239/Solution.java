package cn.tianwenjie.solution239;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 暴力法
 */
//public class Solution {
//  public int[] maxSlidingWindow(int[] nums, int k) {
//    if (nums.length == 0 || k == 0) {
//      return new int[0];
//    }
//    int[] result = new int[nums.length - k + 1];
//    for (int i = 0; i < nums.length - k + 1; i++) {
//      int max = nums[i];
//      for (int j = i; j < i + k; j++) {
//        max = Math.max(max, nums[j]);
//      }
//      result[i] = max;
//    }
//    return result;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//    System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1, -1}, 1)));
//  }
//}


/**
 * 双端队列实现
 */
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) {
      return new int[0];
    }
    if (k == 1) {
      return nums;
    }

    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
        deque.removeFirst();
      }

      while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.addLast(i);

      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.getFirst()];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1, -1}, 1)));
  }
}
