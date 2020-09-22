package cn.tianwenjie.solution75;


import java.util.Arrays;

public class Solution {

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

  public static void main(String[] args) {
    int[] nums = new int[] {2, 0, 2, 1, 1, 0};
    Solution solution = new Solution();
    solution.sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}
