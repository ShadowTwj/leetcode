package cn.tianwenjie.solution98;

import java.util.ArrayList;
import java.util.List;

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
//  public boolean isValidBST(TreeNode root) {
//    return helper(root, null, null);
//  }
//
//  private boolean helper(TreeNode root, Integer lower, Integer upper) {
//    if (root == null) {
//      return true;
//    }
//    int val = root.val;
//    if (lower != null && val <= lower) {
//      return false;
//    }
//    if (upper != null && val >= upper) {
//      return false;
//    }
//
//    if (!helper(root.right, val, upper)) {
//      return false;
//    }
//    return helper(root.left, lower, val);
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    TreeNode treeNode = new TreeNode(2);
//    treeNode.left = new TreeNode(1);
//    treeNode.right = new TreeNode(3);
//    System.out.println(solution.isValidBST(treeNode));
//
//    TreeNode treeNode1 = new TreeNode(5);
//    treeNode1.left = new TreeNode(1);
//    treeNode1.right = new TreeNode(4);
//    treeNode1.right.left = new TreeNode(3);
//    treeNode1.right.right = new TreeNode(6);
//    System.out.println(solution.isValidBST(treeNode1));
//
//    TreeNode treeNode2 = new TreeNode(10);
//    treeNode2.left = new TreeNode(5);
//    treeNode2.right = new TreeNode(15);
//    treeNode2.right.left = new TreeNode(6);
//    treeNode2.right.right = new TreeNode(20);
//    System.out.println(solution.isValidBST(treeNode2));
//  }
//}


/**
 * 前序遍历实现
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(solution.isValidBST(treeNode));

        TreeNode treeNode1 = new TreeNode(5);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(4);
        treeNode1.right.left = new TreeNode(3);
        treeNode1.right.right = new TreeNode(6);
        System.out.println(solution.isValidBST(treeNode1));

        TreeNode treeNode2 = new TreeNode(10);
        treeNode2.left = new TreeNode(5);
        treeNode2.right = new TreeNode(15);
        treeNode2.right.left = new TreeNode(6);
        treeNode2.right.right = new TreeNode(20);
        System.out.println(solution.isValidBST(treeNode2));
    }
}
