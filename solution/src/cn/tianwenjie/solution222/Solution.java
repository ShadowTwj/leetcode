package cn.tianwenjie.solution222;


/**
 * Definition for a binary tree node.
 */
class TreeNode {
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


/**
 * 遍历所有节点实现
 * 时间复杂度O(n)
 */
//public class Solution {
//  public int countNodes(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//
//    return 1 + countNodes(root.left) + countNodes(root.right);
//  }
//}


/**
 * 遍历部分节点
 * 时间复杂度O(logN*logN)
 */
public class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    TreeNode left = root, right = root;
    int leftHigh = 0, rightHigh = 0;

    //左节点深度
    while (left != null) {
      leftHigh++;
      left = left.left;
    }

    //右节点深度
    while (right != null) {
      rightHigh++;
      right = right.right;
    }

    if (leftHigh == rightHigh) {
      return (int) Math.pow(2, leftHigh) - 1;
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
