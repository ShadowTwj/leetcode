package cn.tianwenjie.solution145;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
 * 递归
 */
//public class Solution {
//  public List<Integer> postorderTraversal(TreeNode root) {
//    List<Integer> result = new ArrayList<>();
//    postorder(root, result);
//    return result;
//  }
//
//  public void postorder(TreeNode root, List<Integer> result) {
//    if (root == null) {
//      return;
//    }
//    postorder(root.left, result);
//    postorder(root.right, result);
//    result.add(root.val);
//  }
//
//  public static void main(String[] args) {
//    TreeNode treeNode = new TreeNode(1);
//    treeNode.right = new TreeNode(2);
//    treeNode.right.left = new TreeNode(3);
//    Solution solution = new Solution();
//    System.out.println(solution.postorderTraversal(treeNode));
//  }
//}


/**
 * 栈迭代实现
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            // 按后序遍历相反的顺序添加到LinkedList的头部，输出时则正好是后序遍历的顺序
            result.addFirst(treeNode.val);

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(treeNode));
    }
}
