package cn.tianwenjie.solution538;

import java.util.LinkedList;

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
 * 迭代实现
 */
//public class Solution {
//  public TreeNode convertBST(TreeNode root) {
//    LinkedList<TreeNode> stack = new LinkedList<>();
//    int sum = 0;
//    TreeNode temp = root;
//
//    while (root != null || !stack.isEmpty()) {
//      while (root != null) {
//        stack.addLast(root);
//        root = root.right;
//      }
//
//      root = stack.removeLast();
//      sum += root.val;
//      root.val = sum;
//      root = root.left;
//    }
//
//    return temp;
//  }
//
//  public static void main(String[] args) {
//  }
//}


/**
 * 递归实现
 * 反序中序遍历
 */
public class Solution {
  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return null;
    }
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);

    return root;
  }

  public static void main(String[] args) {
  }
}
