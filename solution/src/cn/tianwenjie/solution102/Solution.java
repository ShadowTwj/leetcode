package cn.tianwenjie.solution102;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
//  public List<List<Integer>> levelOrder(TreeNode root) {
//    List<List<Integer>> result = new ArrayList<>();
//    levelOrder(root, result, 0);
//    return result;
//  }
//
//  public void levelOrder(TreeNode root, List<List<Integer>> result, int level) {
//    if (root == null) {
//      return;
//    }
//    if (result.size() == level) {
//      result.add(new ArrayList<>());
//    }
//    result.get(level).add(root.val);
//
//    level++;
//    levelOrder(root.left, result, level);
//    levelOrder(root.right, result, level);
//  }
//
//  public static void main(String[] args) {
//    TreeNode treeNode = new TreeNode(3);
//    treeNode.left = new TreeNode(9);
//    treeNode.right = new TreeNode(20);
//    treeNode.right.left = new TreeNode(15);
//    treeNode.right.right = new TreeNode(7);
//    Solution solution = new Solution();
//    System.out.println(solution.levelOrder(treeNode));
//  }
//}


/**
 * 迭代实现
 */
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    Queue<TreeNode> tempQueue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> levelVal = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode treeNode = queue.poll();
        levelVal.add(treeNode.val);
        if (treeNode.left != null) {
          tempQueue.add(treeNode.left);
        }
        if (treeNode.right != null) {
          tempQueue.add(treeNode.right);
        }
      }
      result.add(levelVal);
      queue.addAll(tempQueue);
      tempQueue.clear();
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);
    Solution solution = new Solution();
    System.out.println(solution.levelOrder(treeNode));
  }
}
