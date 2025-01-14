/**
给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。

 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。

 返回被除数 dividend 除以除数 divisor 得到的 商 。

 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231
 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。



 示例 1:


输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = 3.33333.. ，向零截断后得到 3 。

 示例 2:


输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。



 提示：


 -2³¹ <= dividend, divisor <= 2³¹ - 1
 divisor != 0


 Related Topics 位运算 数学 👍 1249 👎 0

*/

package cn.tianwenjie.leetcode.editor.cn;

class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();

        int result = solution.divide(-2147483648, 1);
        System.out.println(result);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //全部转为负数，不会超出范围
        int dvd = dividend > 0 ? -dividend : dividend;
        int dvs = divisor > 0 ? -divisor : divisor;

        int result = 0;
        //除数累加最多为-2^31/2，防止越界
        int boundary = Integer.MIN_VALUE >> 1;
        while (dvs >= dvd) {
            int temp = dvs;
            int tempRes = 1;
            while (temp >= boundary && dvd <= temp << 1) {
                temp <<= 1;
                tempRes <<= 1;
            }
            dvd -= temp;
            result += tempRes;
        }

        if (dividend < 0 ^ divisor < 0) {
            result = -result;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}