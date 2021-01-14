### 二叉树展开为链表(Flatten Binary Tree to Linked List)

#### 题目描述

给定一个二叉树，`原地`将它展开为一个单链表。

例如，给定二叉树

```
    1
   / \
  2   5
 / \   \
3   4   6
```

将其展开为：

```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

#### 题解

- 前序遍历实现

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
  public void flatten(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    preorderTraversal(root, list);
    for (int i = 0; i < list.size() - 1; i++) {
      TreeNode node = list.get(i);
      node.left = null;
      node.right = list.get(i + 1);
    }
  }

  private void preorderTraversal(TreeNode root, List<TreeNode> list) {
    if (root != null) {
      list.add(root);
      preorderTraversal(root.left, list);
      preorderTraversal(root.right, list);
    }
  }
}
```

- 递归实现

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.right = left;
    root.left = null;

    TreeNode node = root;
    while (node.right != null) {
      node = node.right;
    }

    node.right = right;
  }
}

```
