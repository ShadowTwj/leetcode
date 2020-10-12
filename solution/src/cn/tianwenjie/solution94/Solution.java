package cn.tianwenjie.solution94;


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
//public class Solution {
//  public List<Integer> inorderTraversal(TreeNode root) {
//    List<Integer> result = new ArrayList<>();
//    pre(root, result);
//    return result;
//  }
//
//  public void pre(TreeNode root, List<Integer> result) {
//    if (root == null) {
//      return;
//    }
//    pre(root.left, result);
//    result.add(root.val);
//    pre(root.right, result);
//  }
//
//  public static void main(String[] args) {
//    TreeNode treeNode = new TreeNode(1);
//    treeNode.right = new TreeNode(2);
//    treeNode.right.left = new TreeNode(3);
//    Solution solution = new Solution();
//    System.out.println(solution.inorderTraversal(treeNode));
//  }
//}


/**
 * 栈迭代实现
 */
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      result.add(cur.val);
      cur = cur.right;
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    treeNode.right.left = new TreeNode(3);
    Solution solution = new Solution();
    System.out.println(solution.inorderTraversal(treeNode));
  }
}
