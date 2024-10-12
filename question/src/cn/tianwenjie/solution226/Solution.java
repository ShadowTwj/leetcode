package cn.tianwenjie.solution226;

import java.util.LinkedList;
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
//  public TreeNode invertTree(TreeNode root) {
//    if (root == null) {
//      return null;
//    }
//    TreeNode temp = root.left;
//    root.left = root.right;
//    root.right = temp;
//    invertTree(root.left);
//    invertTree(root.right);
//
//    return root;
//  }
//}


/**
 * 迭代实现
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return root;
    }
}
