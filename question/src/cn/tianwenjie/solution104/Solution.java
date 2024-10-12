package cn.tianwenjie.solution104;

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
//  public int maxDepth(TreeNode root) {
//    return maxDepth(root, 0);
//  }
//
//  public int maxDepth(TreeNode root, int depth) {
//    if (root == null) {
//      return depth;
//    }
//    return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
//  }
//
//  public static void main(String[] args) {
//    TreeNode treeNode = new TreeNode(3);
//    treeNode.left = new TreeNode(9);
//    treeNode.right = new TreeNode(20);
//    treeNode.right.left = new TreeNode(15);
//    treeNode.right.right = new TreeNode(7);
//    Solution solution = new Solution();
//    System.out.println(solution.maxDepth(treeNode));
//  }
//}


/**
 * 迭代实现(广度优先搜索)
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(treeNode));
    }
}
