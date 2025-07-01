/**
给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 
行有 3 个球，依此类推。 

 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。 

 返回可以实现的三角形的 最大 高度。 

 

 示例 1： 

 
 输入： red = 2, blue = 4 
 

 输出： 3 

 解释： 

 

 上图显示了唯一可能的排列方式。 

 示例 2： 

 
 输入： red = 2, blue = 1 
 

 输出： 2 

 解释： 

 上图显示了唯一可能的排列方式。 

 示例 3： 

 
 输入： red = 1, blue = 1 
 

 输出： 1 

 示例 4： 

 
 输入： red = 10, blue = 1 
 

 输出： 2 

 解释： 

 上图显示了唯一可能的排列方式。 

 

 提示： 

 
 1 <= red, blue <= 100 
 

 Related Topics 数组 枚举 👍 21 👎 0

*/
  
package cn.tianwenjie.leetcode.editor.cn;

class MaximumHeightOfATriangle {
    public static void main(String[] args) {
        Solution solution = new MaximumHeightOfATriangle().new Solution();
        int i = solution.maxHeightOfTriangle(2, 4);
        System.out.println(i);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(height(red, blue), height(blue, red));
    }

    public int height(int first, int second) {
        int firstStart = 1;
        int secondStart = 2;
        int res = 0;
        do {
            if (firstStart <= first) {
                res++;
                first -= firstStart;
                firstStart += 2;
            } else {
                return res;
            }
            if (secondStart <= second) {
                res++;
                second -= secondStart;
                secondStart += 2;
            } else {
                return res;
            }
        } while (true);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}