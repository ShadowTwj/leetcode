package cn.tianwenjie.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
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

  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    Solution solution = new Solution();
    System.out.println(solution.threeSum(nums));
  }
}
