package cn.tianwenjie.solution230;

import java.util.LinkedList;

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
 * 递归实现
 */
//public class Solution {
//  public int kthSmallest(TreeNode root, int k) {
//    traverse(root, k);
//    return res;
//  }
//
//  int num = 1;
//  int res;
//
//  private void traverse(TreeNode root, int k) {
//    if (root == null) {
//      return;
//    }
//
//    traverse(root.left, k);
//    if (k == num++) {
//      res = root.val;
//    }
//    traverse(root.right, k);
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    solution.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1);
//    solution.kthSmallest(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)), 1);
//  }
//}


/**
 * 迭代实现
 */
public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (true) {
      while (root != null) {
        stack.addLast(root);
        root = root.left;
      }

      root = stack.removeLast();
      if (--k == 0) {
        return root.val;
      }
      root = root.right;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1);
    solution.kthSmallest(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)), 1);
  }
}
