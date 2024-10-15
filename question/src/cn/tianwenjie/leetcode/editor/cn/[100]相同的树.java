/**
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。



 示例 1：


输入：p = [1,2,3], q = [1,2,3]
输出：true


 示例 2：


输入：p = [1,2], q = [1,null,2]
输出：false


 示例 3：


输入：p = [1,2,1], q = [1,1,2]
输出：false




 提示：


 两棵树上的节点数目都在范围 [0, 100] 内
 -10⁴ <= Node.val <= 10⁴


 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1176 👎 0

*/

package cn.tianwenjie.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
    }

//深度优先搜索
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//
//        if (p.val != q.val) {
//            return false;
//        }
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }
//}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//广度优先搜索
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty() ) {
            TreeNode pNode = queue1.poll();
            TreeNode qNode = queue2.poll();

            if (pNode.val != qNode.val) {
                return false;
            }

            TreeNode pLeft = pNode.left;
            TreeNode pRight = pNode.right;
            TreeNode qLeft = qNode.left;
            TreeNode qRight = qNode.right;

            if (pLeft == null ^ qLeft == null) {
                return false;
            }
            if (pRight == null ^ qRight == null) {
                return false;
            }

            if (pLeft != null) {
                queue1.add(pLeft);
            }
            if (pRight != null) {
                queue1.add(pRight);
            }
            if (qLeft != null) {
                queue2.add(qLeft);
            }
            if (qRight != null) {
                queue2.add(qRight);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}