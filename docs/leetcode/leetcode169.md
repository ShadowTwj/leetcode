### 多数元素(Majority Element)

#### 题目描述

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于`⌊ n/2 ⌋`的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例 1:**

```
输入: [3,2,3]
输出: 3
```

**示例 2:**

```
输入: [2,2,1,1,1,2,2]
输出: 2
```

#### 题解

- 排序实现

```java
class Solution {
     public int majorityElement(int[] nums) {
         int time = nums.length / 2;
         int num = 0;
         Arrays.sort(nums);
         for (int i = 0; i < nums.length; i++) {
           int currTime = 0;
           for (int j = i + 1; j < nums.length; j++) {
             if (nums[i] == nums[j]) {
               currTime++;
             } else {
               break;
             }
           }
           if (currTime >= time) {
             num = nums[i];
             break;
           }
         }
         return num;
     }
}
```

- 排序进阶

```java
class Solution {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      return nums[nums.length / 2];
    }
}
```

- 哈希表实现

```java
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
          if (counts.containsKey(num)) {
            counts.put(num, counts.get(num) + 1);
          } else {
            counts.put(num, 1);
          }
        }
    
        Map.Entry<Integer, Integer> entry = null;
        for (Map.Entry<Integer, Integer> temp : counts.entrySet()) {
          if (entry == null || temp.getValue() > entry.getValue()) {
            entry = temp;
          }
        }
    
        return entry.getKey();
    }
}
```
