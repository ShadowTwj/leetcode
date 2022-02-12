### 二叉树的最大深度(Binary Tree Postorder Traversal)

#### 题目描述

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。

**示例:**
给定二叉树 `[3,9,20,null,null,15,7]`，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。

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
     public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
      }
    
     public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
          return depth;
        }
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
     }
}
```

- 迭代实现(广度优先搜索)

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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        if (root == null) {
          return maxDepth;
        }
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
}
```
