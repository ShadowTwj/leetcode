package cn.tianwenjie.solution700;

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
//public class Solution {
//  public TreeNode searchBST(TreeNode root, int val) {
//    if (root == null || root.val == val) {
//      return root;
//    }
//
//    return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
//  }
//}


/**
 * 迭代实现
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }

        return root;
    }
}
