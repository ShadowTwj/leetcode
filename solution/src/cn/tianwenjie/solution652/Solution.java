package cn.tianwenjie.solution652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Solution {
  Map<String, Integer> map = new HashMap<>();
  List<TreeNode> result = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    lookup(root);
    return result;
  }

  private String lookup(TreeNode root) {
    if (root == null) {
      return "#";
    }

    String left = lookup(root.left);
    String right = lookup(root.right);

    String unique = left + "," + right + "," + root.val;
    int num = map.getOrDefault(unique, 0);
    if (num == 1) {
      result.add(root);
    }
    map.put(unique, ++num);

    return unique;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
    List<TreeNode> result = solution.findDuplicateSubtrees(node);
    System.out.println(result);
  }
}
