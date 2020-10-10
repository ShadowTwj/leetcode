### 滑动窗口的最大值

#### 题目描述
给定一个数组`nums`和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

**示例:**
```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

**提示:**
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

#### 题解
- 暴力实现
```java
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
      return new int[0];
    }

    int size = nums.length - k + 1;
    int[] res = new int[size];
    for (int i = 0; i < size; i++) {
      int max = nums[i];
      for (int j = i; j < k + i; j++) {
        max = Math.max(max, nums[j]);
      }
      res[i] = max;
    }

    return res;
  }
}
```
- 双端队列实现
```java
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
}
```
