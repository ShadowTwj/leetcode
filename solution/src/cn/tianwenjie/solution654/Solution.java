package cn.tianwenjie.solution654;

import java.util.Stack;

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
//  public TreeNode constructMaximumBinaryTree(int[] nums) {
//    return helper(nums, 0, nums.length);
//  }
//
//  private TreeNode helper(int[] nums, int n, int m) {
//    if (n == m) {
//      return null;
//    }
//
//    int max = Integer.MIN_VALUE, index = -1;
//    for (int i = n; i < m; i++) {
//      if (nums[i] > max) {
//        max = nums[i];
//        index = i;
//      }
//    }
//
//    TreeNode node = new TreeNode(max);
//    node.left = helper(nums, n, index);
//    node.right = helper(nums, index + 1, m);
//
//    return node;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    TreeNode node = solution.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
//    System.out.println(node.toString());
//  }
//}


/**
 * 单调栈实现
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;

        for (int i = 0; i < nums.length; i++) {
            node = new TreeNode(nums[i]);

            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                TreeNode temp = stack.pop();
                if (!stack.isEmpty() && stack.peek().val < nums[i]) {
                    stack.peek().right = temp;
                } else {
                    node.left = temp;
                }
            }

            stack.push(node);
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
        System.out.println(node.toString());
    }
}
