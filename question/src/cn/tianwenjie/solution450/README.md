### 删除二叉搜索树中的节点(Delete Node in a BST)

#### 题目描述

给定一个二叉搜索树的根节点 **root** 和一个值 **key**，删除二叉搜索树中的 **key** 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

1. 首先找到需要删除的节点；
2. 如果找到了，删除它。

**说明：** 要求算法时间复杂度为 O(h)，h 为树的高度。

**示例:**

```
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
```

#### 题解

- 递归实现

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public TreeNode deleteNode(TreeNode root, int key) {
         if (root == null) {
           return null;
         }
     
         if (root.val > key) {
           root.left = deleteNode(root.left, key);
         } else if (root.val < key) {
           root.right = deleteNode(root.right, key);
         } else {
           // 只有左子树时
           if (root.right == null) {
             return root.left;
           } else {
             // 右子树不为Null,找到右子树中的最小节点
             TreeNode node = root.right;
             // 右子树中最小节点的父节点
             TreeNode parentNode = root;
             while (node.left != null) {
               parentNode = node;
               node = node.left;
             }
             root.val = node.val;
             // 最小节点一定没有左子树，但可能有右子树，把右子树指向父节点
             if (parentNode.left == node) {
               parentNode.left = node.right;
             }
             if (parentNode.right == node) {
               parentNode.right = node.right;
             }
           }
         }
         return root;
     }
}
```

- 迭代实现

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
```
