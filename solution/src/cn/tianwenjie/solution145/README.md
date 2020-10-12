### 二叉树的后序遍历(Binary Tree Postorder Traversal)

#### 题目描述
给定一个二叉树，返回它的 后序 遍历。

示例:
```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
```

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
      }
    
      public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
          return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
      }
}
```

- 栈迭代实现
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
          return result;
        }
        stack.push(root);
        while (!stack.empty()) {
          TreeNode treeNode = stack.pop();
          // 按后序遍历相反的顺序添加到LinkedList的头部，输出时则正好是后序遍历的顺序
          result.addFirst(treeNode.val);
    
          if (treeNode.left != null) {
            stack.push(treeNode.left);
          }
    
          if (treeNode.right != null) {
            stack.push(treeNode.right);
          }
        }
        return result;
      }
}
```
