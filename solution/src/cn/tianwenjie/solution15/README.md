### 三数之和(Sort Colors)

#### 题目描述
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

**注意:** 答案中不可以包含重复的三元组。

示例:
```
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

#### 题解
- 排序双指针
```java
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums.length == 0) {
        return result;
      }
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
        if (i >0 && nums[i] == nums[i - 1]) {
          continue;
        }
        int curr = nums[i];
        // left pointer
        int j = i + 1;
        // right pointer
        int k = nums.length - 1;
        while (j < k) {
          if (nums[j] + nums[k] + curr == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
            temp.add(nums[k]);
            result.add(temp);
            j++;
            k--;
            while (j < nums.length && nums[j] == nums[j - 1]) {
              j++;
            }
            while (k > j && nums[k] == nums[k + 1]) {
              k--;
            }
          } else if (nums[j] + nums[k] > -curr) {
            k--;
          } else {
            j++;
          }
        }
      }
      return result;
  }
}
```
