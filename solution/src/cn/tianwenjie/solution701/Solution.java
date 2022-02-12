package cn.tianwenjie.solution701;

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
//class Solution {
//  public TreeNode insertIntoBST(TreeNode root, int val) {
//    if (root == null) {
//      return new TreeNode(val);
//    }
//
//    if (root.val > val) {
//      root.left = insertIntoBST(root.left, val);
//    } else {
//      root.right = insertIntoBST(root.right, val);
//    }
//
//    return root;
//  }
//}


/**
 * 迭代实现
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (true) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }

        return root;
    }
}
