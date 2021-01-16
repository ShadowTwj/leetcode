### 最大二叉树(Maximum Binary Tree)

#### 题目描述

给定一个不含重复元素的整数数组 `nums` 。一个以此数组直接递归构建的 **最大二叉树** 定义如下：

1. 二叉树的根是数组 `nums` 中的最大元素。
2. 左子树是通过数组中 **最大值左边部分** 递归构造出的最大二叉树。
3. 右子树是通过数组中 **最大值右边部分** 递归构造出的最大二叉树。

返回有给定数组 `nums` 构建的 **最大二叉树** 。

示例1:
![image](https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg)

```
输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
```

示例2:
![image](https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg)

```
输入：nums = [3,2,1]
输出：[3,null,2,null,1]
```

提示:

- 1 <= nums.length <= 1000
- 0 <= nums[i] <= 1000
- nums 中的所有整数 互不相同

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
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return helper(nums, 0, nums.length);
  }

  private TreeNode helper(int[] nums, int n, int m) {
    if (n == m) {
      return null;
    }

    int max = Integer.MIN_VALUE, index = -1;
    for (int i = n; i < m; i++) {
      if (nums[i] > max) {
        max = nums[i];
        index = i;
      }
    }

    TreeNode node = new TreeNode(max);
    node.left = helper(nums, n, index);
    node.right = helper(nums, index + 1, m);

    return node;
  }
}
```

- 单调栈实现

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
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = null;

    for (int i = 0; i < nums.length; i++) {
      node = new TreeNode(nums[i]);

      while (!stack.isEmpty() && stack.peek().val < nums[i]) {
        TreeNode temp = stack.pop();
        if (!stack.isEmpty() && stack.peek().val < nums[i]) {
          stack.peek().right = temp;
        } else {
          node.left = temp;
        }
      }

      stack.push(node);
    }

    while (!stack.isEmpty()) {
      node = stack.pop();
      if (!stack.isEmpty()) {
        stack.peek().right = node;
      }
    }
    return node;
  }
}
```
