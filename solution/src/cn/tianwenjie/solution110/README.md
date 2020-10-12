### 平衡二叉树(Balanced Binary Tree)

#### 题目描述
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：
> 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

**示例1:**
给定二叉树 `[3,9,20,null,null,15,7]`
```
    3
   / \
  9  20
    /  \
   15   7
```
返回 `true` 。

**示例2:**
给定二叉树 `[1,2,2,3,3,null,null,4,4]`
```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```
返回 `false` 。

#### 题解
- 递归实现(自顶向下)
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
     public boolean isBalanced(TreeNode root) {
         if (root == null) {
           return true;
         }
         // 每个节点的左右子树的高度差都小于2
         return Math.abs(height(root.left, 0) - height(root.right, 0)) < 2 && isBalanced(root.left) && isBalanced(root.right);
       }
     
       /**
        * 节点的最大高度
        */
       public int height(TreeNode root, int height) {
         if (root == null) {
           return height;
         }
         return Math.max(height(root.left, height + 1), height(root.right, height + 1));
     }
}
```

- 递归实现(自底向上)
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
    private boolean flag = true;
    
      public boolean isBalanced(TreeNode root) {
        helper(root,0);
        return flag;
      }
    
      public int helper(TreeNode root,int height) {
        if (root == null) {
          return height;
        }
        int left = helper(root.left, height + 1);
        int right = helper(root.right, height + 1);
        if (Math.abs(left - right) > 1) {
          this.flag = false;
        }
        return Math.max(left, right);
    }
}
```
