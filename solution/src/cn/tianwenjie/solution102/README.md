### 二叉树的层次遍历(Binary Tree Postorder Traversal)

#### 题目描述
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7

```
返回其层次遍历结果：
```
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, result, 0);
        return result;
      }
    
    public void levelOrder(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
          return;
        }
        if (result.size() == level) {
          result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        
        level++;
        levelOrder(root.left, result, level);
        levelOrder(root.right, result, level);
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
          return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> tempQueue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
          List<Integer> levelVal = new ArrayList<>();
          while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            levelVal.add(treeNode.val);
            if (treeNode.left != null) {
              tempQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
              tempQueue.add(treeNode.right);
            }
          }
          result.add(levelVal);
          queue.addAll(tempQueue);
          tempQueue.clear();
        }
        return result;
    }
}
```
