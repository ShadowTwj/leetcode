package cn.tianwenjie.solution169;

/**
 * 排序实现
 * <p>
 * 排序进阶
 * <p>
 * 哈希表实现
 */
//public class Solution {
//  public int majorityElement(int[] nums) {
//    int time = nums.length / 2;
//    int num = 0;
//    Arrays.sort(nums);
//    for (int i = 0; i < nums.length; i++) {
//      int currTime = 0;
//      for (int j = i + 1; j < nums.length; j++) {
//        if (nums[i] == nums[j]) {
//          currTime++;
//        } else {
//          break;
//        }
//      }
//      if (currTime >= time) {
//        num = nums[i];
//        break;
//      }
//    }
//    return num;
//  }
//
//  public static void main(String[] args) {
//    int[] nums = new int[]{3,2,3};
//    int[] nums2 = new int[]{2,2,1,1,1,2,2};
//    Solution solution = new Solution();
//    System.out.println(solution.majorityElement(nums));
//    System.out.println(solution.majorityElement(nums2));
//  }
//}

/**
 * 排序进阶
 */
//public class Solution {
//  public int majorityElement(int[] nums) {
//    Arrays.sort(nums);
//    return nums[nums.length / 2];
//  }
//
//  public static void main(String[] args) {
//    int[] nums = new int[] {3, 2, 3};
//    int[] nums2 = new int[] {2, 2, 1, 1, 1, 2, 2};
//    Solution solution = new Solution();
//    System.out.println(solution.majorityElement(nums));
//    System.out.println(solution.majorityElement(nums2));
//  }
//}

/**
 * 哈希表实现
 */
//public class Solution {
//  public int majorityElement(int[] nums) {
//    Map<Integer, Integer> counts = new HashMap<>();
//    for (int num : nums) {
//      if (counts.containsKey(num)) {
//        counts.put(num, counts.get(num) + 1);
//      } else {
//        counts.put(num, 1);
//      }
//    }
//
//    Map.Entry<Integer, Integer> entry = null;
//    for (Map.Entry<Integer, Integer> temp : counts.entrySet()) {
//      if (entry == null || temp.getValue() > entry.getValue()) {
//        entry = temp;
//      }
//    }
//
//    return entry.getKey();
//  }
//
//  public static void main(String[] args) {
//    int[] nums = new int[] {3, 2, 3};
//    int[] nums2 = new int[] {2, 2, 1, 1, 1, 2, 2};
//    Solution solution = new Solution();
//    System.out.println(solution.majorityElement(nums));
//    System.out.println(solution.majorityElement(nums2));
//  }
//}


/**
 * 摩尔投票法实现
 * 核心思想：多数元素和其他元素相互抵消，剩下的一定是最少1个的多数，
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                if (--count == 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 3};
        int[] nums2 = new int[] {2, 2, 1, 1, 1, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
        System.out.println(solution.majorityElement(nums2));
    }
}
