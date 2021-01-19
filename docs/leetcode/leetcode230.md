### 二叉搜索树中第K小的元素(Kth Smallest Element in a BST)

#### 题目描述

给定一个二叉搜索树，编写一个函数 `kthSmallest` 来查找其中第 k 个最小的元素。

**说明：**
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例1:

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
```

示例2:

```
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
```

**进阶：**
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 `kthSmallest` 函数？

#### 题解

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
  public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return res;
  }

  int num = 1;
  int res;

  private void traverse(TreeNode root, int k) {
    if (root == null) {
      return;
    }

    traverse(root.left, k);
    if (k == num++) {
      res = root.val;
    }
    traverse(root.right, k);
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
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (true) {
      while (root != null) {
        stack.addLast(root);
        root = root.left;
      }

      root = stack.removeLast();
      if (--k == 0) {
        return root.val;
      }
      root = root.right;
    }
  }
}
```
