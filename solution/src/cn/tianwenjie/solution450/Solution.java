package cn.tianwenjie.solution450;

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
//  public TreeNode deleteNode(TreeNode root, int key) {
//    if (root == null) {
//      return null;
//    }
//
//    if (root.val > key) {
//      root.left = deleteNode(root.left, key);
//    } else if (root.val < key) {
//      root.right = deleteNode(root.right, key);
//    } else {
//      // 只有左子树时
//      if (root.right == null) {
//        return root.left;
//      } else {
//        // 右子树不为Null,找到右子树中的最小节点
//        TreeNode node = root.right;
//        // 右子树中最小节点的父节点
//        TreeNode parentNode = root;
//        while (node.left != null) {
//          parentNode = node;
//          node = node.left;
//        }
//        root.val = node.val;
//        // 最小节点一定没有左子树，但可能有右子树，把右子树指向父节点
//        if (parentNode.left == node) {
//          parentNode.left = node.right;
//        }
//        if (parentNode.right == node) {
//          parentNode.right = node.right;
//        }
//      }
//    }
//    return root;
//  }
//
//  public static void main(String[] args) {
//    TreeNode treeNode = new TreeNode(5);
//    treeNode.left = new TreeNode(3);
//    treeNode.right = new TreeNode(6);
//    treeNode.left.left = new TreeNode(2);
//    treeNode.left.right = new TreeNode(4);
//    treeNode.right.right = new TreeNode(7);
//    Solution solution = new Solution();
//    System.out.println(solution.deleteNode(treeNode, 3));
//  }
//}


/**
 * 迭代实现
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 删除的节点，初始化执行根节点
        TreeNode node = root;
        // 删除节点的父节点
        TreeNode parentNode = null;
        while (node != null && node.val != key) {
            parentNode = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (node == null) {
            return root;
        }

        // 删除的节点有两个子节点
        if (node.left != null && node.right != null) {
            // 右子树中的最小节点
            TreeNode min = node.right;
            // 最小节点的父节点
            TreeNode parentMin = node;
            while (min.left != null) {
                parentMin = min;
                min = min.left;
            }
            // 把最小节点的值赋给需要删除的节点
            node.val = min.val;
            // 要删除的节点变为了右子树中的最小节点
            node = min;
            parentNode = parentMin;
        }

        // 删除的节点是叶子节点或者只有一个子节点
        TreeNode child; // node(删除节点)的子节点
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }

        if (parentNode == null) {
            // 删除的是根节点
            root = child;
        } else if (parentNode.left == node) {
            parentNode.left = child;
        } else {
            parentNode.right = child;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.deleteNode(treeNode, 3));
    }
}
