/**
给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。



 示例 1：


输入:a = "11", b = "1"
输出："100"

 示例 2：


输入：a = "1010", b = "1011"
输出："10101"



 提示：


 1 <= a.length, b.length <= 10⁴
 a 和 b 仅由字符 '0' 或 '1' 组成
 字符串如果不是 "0" ，就不含前导零


 Related Topics 位运算 数学 字符串 模拟 👍 1235 👎 0

*/

package cn.tianwenjie.leetcode.editor.cn;

class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        String result = solution.addBinary("11", "1");
        System.out.println(result);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum += i < 0 || a.charAt(i) == '0' ? 0 : 1;
            sum += j < 0 || b.charAt(j) == '0' ? 0 : 1;

            sb.append(sum % 2);
            sum = sum / 2;
        }

        if (sum > 0) {
            sb.append(sum % 2);
        }

        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}