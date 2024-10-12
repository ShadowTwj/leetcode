### 寻找重复的子树(Find Duplicate Subtrees)

#### 题目描述

给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意**一棵**的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

示例:

```
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
```

下面是两个重复的子树：

```
      2
     /
    4
```

和

```
    4
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
  Map<String, Integer> map = new HashMap<>();
  List<TreeNode> result = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    lookup(root);
    return result;
  }

  private String lookup(TreeNode root) {
    if (root == null) {
      return "#";
    }

    String left = lookup(root.left);
    String right = lookup(root.right);

    String unique = left + "," + right + "," + root.val;
    int num = map.getOrDefault(unique, 0);
    if (num == 1) {
      result.add(root);
    }
    map.put(unique, ++num);

    return unique;
  }
}
```
