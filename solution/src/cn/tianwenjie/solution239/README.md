### 滑动窗口最大值(Sliding Window Maximum)

#### 题目描述
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

**进阶：**
你能在线性时间复杂度内解决此题吗？

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

**提示：**
- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
- 1 <= k <= nums.length

#### 题解
- 暴力法
```java
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
      return new int[0];
    }
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length - k + 1; i++) {
      int max = nums[i];
      for (int j = i; j < i + k; j++) {
        max = Math.max(max, nums[j]);
      }
      result[i] = max;
    }
    return result;
  }
}
```

- 双端队列实现
```java
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
}
```
