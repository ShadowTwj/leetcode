package cn.tianwenjie.solution297;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


/**
 * 递归实现(前序遍历)
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("#").append(",");
            return;
        }
        result.append(root.val).append(",");
        serialize(root.left, result);
        serialize(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    public TreeNode deserialize(LinkedList<String> data) {
        String s = data.removeFirst();
        if ("#".equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
}

// TODO: 2021/1/20 层级遍历
