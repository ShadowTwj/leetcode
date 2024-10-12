package cn.tianwenjie.solution105;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pStart]);

        int iRootIndex = map.get(node.val);
        //左子树的节点数量
        int leftNum = iRootIndex - iStart;

        node.left = helper(preorder, inorder, pStart + 1, pStart + leftNum, iStart, iRootIndex - 1);
        node.right = helper(preorder, inorder, pStart + leftNum + 1, pEnd, iRootIndex + 1, iEnd);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        System.out.println(node);
    }
}

// TODO: 2021/1/17 迭代实现
