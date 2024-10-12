package cn.tianwenjie.solution110;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 递归实现(自顶向下)
 */
//public class Solution {
//  public boolean isBalanced(TreeNode root) {
//    if (root == null) {
//      return true;
//    }
//    // 每个节点的左右子树的高度差都小于2
//    return Math.abs(height(root.left, 0) - height(root.right, 0)) < 2 && isBalanced(root.left) && isBalanced(root.right);
//  }
//
//  /**
//   * 节点的最大高度
//   */
//  public int height(TreeNode root, int height) {
//    if (root == null) {
//      return height;
//    }
//    return Math.max(height(root.left, height + 1), height(root.right, height + 1));
//  }
//}


/**
 * 递归实现(自底向上)
 */
public class Solution {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        helper(root, 0);
        return flag;
    }

    public int helper(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        int left = helper(root.left, height + 1);
        int right = helper(root.right, height + 1);
        if (Math.abs(left - right) > 1) {
            this.flag = false;
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(treeNode));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(3);
        treeNode1.left.left.left = new TreeNode(4);
        treeNode1.left.left.right = new TreeNode(4);
        System.out.println(solution.isBalanced(treeNode1));
    }
}
