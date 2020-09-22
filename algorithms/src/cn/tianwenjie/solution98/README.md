### 验证二叉搜索树(Validate Binary Search Tree)

#### 题目描述
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

- 节点的左子树只包含小于当前节点的数。
- 节点的右子树只包含大于当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。

**示例1:**
```
输入:
    2
   / \
  1   3
输出: true
```

**示例2:**
```
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
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
  public boolean isValidBST(TreeNode root) {
      return helper(root, null, null);
  }
  
  private boolean helper(TreeNode root, Integer lower, Integer upper) {
      if (root == null) {
        return true;
      }
      int val = root.val;
      if (lower != null && val <= lower) {
        return false;
      }
      if (upper != null && val >= upper) {
        return false;
      }
  
      if (!helper(root.right, val, upper)) {
        return false;
      }
      return helper(root.left, lower, val);
  }
}
```

- 中序遍历实现
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
  public boolean isValidBST(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inorderTraversal(root, result);
      for (int i = 0; i < result.size() - 1; i++) {
        if (result.get(i) >= result.get(i + 1)) {
          return false;
        }
      }
      return true;
  }
  
  private void inorderTraversal(TreeNode root, List<Integer> list) {
      if (root == null) {
        return;
      }
      inorderTraversal(root.left, list);
      list.add(root.val);
      inorderTraversal(root.right, list);
  }
}

```
