package cn.tianwenjie.solution116;

import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


/**
 * 递归实现
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        //连接相同父节点的两个子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        //连接不同父节点的两个子节点
        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = new Node(1, new Node(2), new Node(3), null);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        solution.connect(node);
        System.out.println(node);
    }
}

/**
 * 迭代实现
 */
//public class Solution {
//  public Node connect(Node root) {
//    if (root == null) {
//      return null;
//    }
//
//    LinkedList<Node> queue = new LinkedList<>();
//    queue.add(root);
//
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//
//      for (int i = 0; i < size; i++) {
//        Node node = queue.poll();
//
//        //只连接当前层
//        if (i < size - 1) {
//          node.next = queue.peek();
//        }
//
//        //写入下一层节点
//        if (node.left != null) {
//          queue.add(node.left);
//        }
//        if (node.right != null) {
//          queue.add(node.right);
//        }
//      }
//    }
//    return root;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    Node node = new Node(1, new Node(2), new Node(3), null);
//    node.left.left = new Node(4);
//    node.left.right = new Node(5);
//    node.right.left = new Node(6);
//    node.right.right = new Node(7);
//    solution.connect(node);
//    System.out.println(node);
//  }
//}
