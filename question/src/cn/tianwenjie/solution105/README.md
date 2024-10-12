### 从前序与中序遍历序列构造二叉树(Construct Binary Tree from Preorder and Inorder Traversal)

#### 题目描述

根据一棵树的前序遍历与中序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
    if (pStart > pEnd) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[pStart]);

    int iRootIndex = map.get(node.val);
    //左子树的节点数量
    int leftNum = iRootIndex - iStart;

    node.left = helper(preorder, inorder, pStart + 1, pStart + leftNum, iStart, iRootIndex - 1);
    node.right = helper(preorder, inorder, pStart + leftNum + 1, pEnd, iRootIndex + 1, iEnd);

    return node;
  }
}
```

- 迭代实现

```java

```
