package cn.tianwenjie.solution114;

import java.util.ArrayList;
import java.util.List;

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
 * 前序遍历实现
 */
//public class Solution {
//  public void flatten(TreeNode root) {
//    List<TreeNode> list = new ArrayList<>();
//    preorderTraversal(root, list);
//    for (int i = 0; i < list.size() - 1; i++) {
//      TreeNode node = list.get(i);
//      node.left = null;
//      node.right = list.get(i + 1);
//    }
//  }
//
//  private void preorderTraversal(TreeNode root, List<TreeNode> list) {
//    if (root != null) {
//      list.add(root);
//      preorderTraversal(root.left, list);
//      preorderTraversal(root.right, list);
//    }
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
//    solution.flatten(root);
//    System.out.println(root);
//  }
//}


/**
 * 递归实现
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;

        root.right = root.left;
        root.left = null;

        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }

        node.right = right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(root);
        System.out.println(root);
    }
}
