package cn.tianwenjie.solution26;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }

        int fast = 1;
        int slow = 1;

        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.removeDuplicates(new int[] {1, 1, 1, 2});

        System.out.println(result);
    }
}