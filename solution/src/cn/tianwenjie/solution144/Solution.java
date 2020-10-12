package cn.tianwenjie.solution144;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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
 * 递归实现
 */
//class Solution {
//  public List<Integer> preorderTraversal(TreeNode root) {
//    List<Integer> result = new ArrayList<>();
//    pre(root, result);
//    return result;
//  }
//
//  public void pre(TreeNode root, List<Integer> result) {
//    if (root == null) {
//      return;
//    }
//    result.add(root.val);
//    pre(root.left, result);
//    pre(root.right, result);
//  }
//
//  public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.right = new TreeNode(2);
//    root.right.left = new TreeNode(3);
//    Solution solution = new Solution();
//    System.out.println(solution.preorderTraversal(root));
//  }
//}


/**
 * 堆栈迭代实现
 */
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode treeNode = stack.pop();
      result.add(treeNode.val);
      if (treeNode.right != null) {
        stack.push(treeNode.right);
      }
      if (treeNode.left != null) {
        stack.push(treeNode.left);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    Solution solution = new Solution();
    System.out.println(solution.preorderTraversal(root));
  }
}
