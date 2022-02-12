package cn.tianwenjie.solution106;

import java.util.HashMap;
import java.util.Map;

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
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (pStart > pEnd) {
            return null;
        }

        int iRoot = map.get(postorder[pEnd]);
        int rightNum = iEnd - iRoot;

        TreeNode node = new TreeNode(postorder[pEnd]);

        node.left = helper(inorder, iStart, iRoot - 1, postorder, pStart, pEnd - rightNum - 1);
        node.right = helper(inorder, iRoot + 1, iEnd, postorder, pEnd - rightNum, pEnd - 1);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
        System.out.println(node);
    }
}

// TODO: 2021/1/17 迭代实现
