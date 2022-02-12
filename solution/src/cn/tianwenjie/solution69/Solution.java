package cn.tianwenjie.solution69;

/**
 * 二分法实现(可能会超出时间范围)
 */
//public class Solution {
//  public int mySqrt(int x) {
//    if (x < 2) {
//      return x;
//    }
//    int left = 2;
//    int right = x / 2;
//    int mid;
//    long num;
//    while (left <= right) {
//      mid = left + (right - left) / 2;
//      num = mid * (long) mid;
//      if (num < x) {
//        left++;
//      } else if (num > x) {
//        right--;
//      } else {
//        return mid;
//      }
//    }
//    return right;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.mySqrt(4));
//    System.out.println(solution.mySqrt(8));
//    System.out.println(solution.mySqrt(2147395599));
//  }
//}


/**
 * 牛顿迭代实现
 */
public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }
        return (int) x1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(2147395599));
    }
}
