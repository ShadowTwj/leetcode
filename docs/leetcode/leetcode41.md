### 缺失的第一个正数(First Missing Positive)

#### 题目描述

给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

**示例1:**

```
输入: [1,2,0]
输出: 3
```

**示例2:**

```
输入: [3,4,-1,1]
输出: 2
```

**示例3:**

```
输入: [7,8,9,11,12]
输出: 1
```

**提示：**

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。

#### 题解

- 排序实现(不符合时间复杂度)

```java
class Solution {
  public int firstMissingPositive(int[] nums) {
      int min = 0;
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
        if (min + 1 == nums[i]) {
          min = nums[i];
        }
      }
      return min + 1;
  }
}
```

- 集合实现(不符合时间复杂度和空间复杂度)

```java
class Solution {
  public int firstMissingPositive(int[] nums) {
    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    int min = 1;
    while (list.contains(min)) {
      min++;
    }
    return min;
  }
}
```

- 哈希表实现(不符合空间复杂度)

```java
class Solution {
  public int firstMissingPositive(int[] nums) {
      // 最小正数一定在1 ~ nums.length + 1中
      // key:1 ~ nums.length + 1, value:出现的次数
      Map<Integer, Integer> counts = new HashMap<>(nums.length);
      for (int i = 1; i <= nums.length + 1; i++) {
        counts.put(i, 0);
      }
      for (int num : nums) {
        if (counts.containsKey(num)) {
          counts.put(num, counts.get(num) + 1);
        }
      }
      Map.Entry<Integer, Integer> min = null;
      for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        if (min == null || entry.getValue() < min.getValue()) {
          min = entry;
        }
      }
      return min.getKey();
  }
}
```

- 将数组当做哈希表

```java
/**
 * 数值i所在的数组的下标应该是i-1
 * 最小正数一定在[1, nums.length + 1]区间内
 */
public class Solution {
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // 最小整数一定在1 ~ nums.length之间，把1 ~ nums.length之间的数从小到大交换排序
      // 不会每次都执行，最坏情况i=0时while把需要交换排序的元素都交换了，后面则不会再执行while，均摊复杂度分析为O(N)
      while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
        // 例如：数值 3 应该放在索引 2 的位置上
        swap(nums, nums[i] - 1, i);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    return nums.length + 1;
  }

  private void swap(int[] nums, int i, int j) {
    // 空间复杂度为O(1)
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
```
