### 颜色分类(Sort Colors)

#### 题目描述
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

**注意:**
不能使用代码库中的排序函数来解决这道题。

示例:
```
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
```

进阶：

- 一个直观的解决方案是使用计数排序的两趟扫描算法。  
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
- 你能想出一个仅使用常数空间的一趟扫描算法吗？

#### 题解
- 快速排序
```java
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
      }
    
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
          return;
        }
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }
    
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
          if (nums[j] < pivot) {
            swap(nums, i, j);
            i++;
          }
        }
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
```

- 
