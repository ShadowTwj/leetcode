### 从中序与后序遍历序列构造二叉树(Construct Binary Tree from Inorder and Postorder Traversal)

#### 题目描述

根据一棵树的中序遍历与后序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
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
public class Solution {
  Map<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
    if (pStart > pEnd) {
      return null;
    }

    int iRoot = map.get(postorder[pEnd]);
    int rightNum = iEnd - iRoot;

    TreeNode node = new TreeNode(postorder[pEnd]);

    node.left = helper(inorder, iStart, iRoot - 1, postorder, pStart, pEnd - rightNum - 1);
    node.right = helper(inorder, iRoot + 1, iEnd, postorder, pEnd - rightNum, pEnd - 1);

    return node;
  }
}
```

- 迭代实现

```java

```
