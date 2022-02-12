package cn.tianwenjie.lcof59I;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 暴力法实现
 */
//public class Solution {
//  public int[] maxSlidingWindow(int[] nums, int k) {
//    if (nums.length == 0 || k == 0) {
//      return new int[0];
//    }
//
//    int size = nums.length - k + 1;
//    int[] res = new int[size];
//    for (int i = 0; i < size; i++) {
//      int max = nums[i];
//      for (int j = i; j < k + i; j++) {
//        max = Math.max(max, nums[j]);
//      }
//      res[i] = max;
//    }
//
//    return res;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    int[] res = solution.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
//    System.out.println(Arrays.toString(res));
//  }
//}


/**
 * 双端队列实现
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //形成滑动窗口后每次移除左边的元素
            if (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }

            //deque中保留最大的
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            //形成滑动窗口后再取最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
