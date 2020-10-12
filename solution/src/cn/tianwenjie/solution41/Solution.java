package cn.tianwenjie.solution41;

/**
 * 排序实现
 */
//public class Solution {
//  public int firstMissingPositive(int[] nums) {
//    int min = 0;
//    Arrays.sort(nums);
//    for (int i = 0; i < nums.length; i++) {
//      if (min + 1 == nums[i]) {
//        min = nums[i];
//      }
//    }
//    return min + 1;
//  }
//
//  public static void main(String[] args) {
//    int[] nums = new int[] {1, 2, 0};
//    int[] nums2 = new int[] {3, 4, -1, 1};
//    int[] nums3 = new int[] {7, 8, 9, 11, 12};
//    int[] nums4 = new int[] {2, 1};
//    Solution solution = new Solution();
//    System.out.println(solution.firstMissingPositive(nums));
//    System.out.println(solution.firstMissingPositive(nums2));
//    System.out.println(solution.firstMissingPositive(nums3));
//    System.out.println(solution.firstMissingPositive(nums4));
//  }
//}


/**
 * 集合实现
 */
//public class Solution {
//  public int firstMissingPositive(int[] nums) {
//    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
//    int min = 1;
//    while (list.contains(min)) {
//      min++;
//    }
//    return min;
//  }
//
//  public static void main(String[] args) {
//    int[] nums = new int[] {1, 2, 0};
//    int[] nums2 = new int[] {3, 4, -1, 1};
//    int[] nums3 = new int[] {7, 8, 9, 11, 12};
//    int[] nums4 = new int[] {2, 1};
//    Solution solution = new Solution();
//    System.out.println(solution.firstMissingPositive(nums));
//    System.out.println(solution.firstMissingPositive(nums2));
//    System.out.println(solution.firstMissingPositive(nums3));
//    System.out.println(solution.firstMissingPositive(nums4));
//  }
//}


/**
 * 哈希表实现
 */
//public class Solution {
//  public int firstMissingPositive(int[] nums) {
//    // 最小正数一定在1 ~ nums.length + 1中
//    // key:1 ~ nums.length + 1, value:出现的次数
//    Map<Integer, Integer> counts = new HashMap<>(nums.length);
//    for (int i = 1; i <= nums.length + 1; i++) {
//      counts.put(i, 0);
//    }
//    for (int num : nums) {
//      if (counts.containsKey(num)) {
//        counts.put(num, counts.get(num) + 1);
//      }
//    }
//    Map.Entry<Integer, Integer> min = null;
//    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//      if (min == null || entry.getValue() < min.getValue()) {
//        min = entry;
//      }
//    }
//    return min.getKey();
//  }
//
//  public static void main(String[] args) {
//    int[] nums = new int[] {1, 2, 0};
//    int[] nums2 = new int[] {3, 4, -1, 1};
//    int[] nums3 = new int[] {7, 8, 9, 11, 12};
//    int[] nums4 = new int[] {2, 1};
//    Solution solution = new Solution();
//    System.out.println(solution.firstMissingPositive(nums));
//    System.out.println(solution.firstMissingPositive(nums2));
//    System.out.println(solution.firstMissingPositive(nums3));
//    System.out.println(solution.firstMissingPositive(nums4));
//  }
//}


/**
 * 将数组当做哈希表
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

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 0};
    int[] nums2 = new int[] {3, 4, -1, 1};
    int[] nums3 = new int[] {7, 8, 9, 11, 12};
    int[] nums4 = new int[] {2, 1};
    Solution solution = new Solution();
    System.out.println(solution.firstMissingPositive(nums));
    System.out.println(solution.firstMissingPositive(nums2));
    System.out.println(solution.firstMissingPositive(nums3));
    System.out.println(solution.firstMissingPositive(nums4));
  }
}
