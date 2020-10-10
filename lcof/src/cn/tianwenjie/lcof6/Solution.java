package cn.tianwenjie.lcof6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


/**
 * 反转list实现
 */
//public class Solution {
//  public int[] reversePrint(ListNode head) {
//    List<Integer> temp = new ArrayList<Integer>();
//    while (head != null) {
//      temp.add(head.val);
//      head = head.next;
//    }
//    int n = temp.size();
//    int[] res = new int[n];
//    for (int i = 0; i < n; i++) {
//      res[i] = temp.get(n - 1 - i);
//    }
//    return res;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    ListNode listNode = new ListNode(1);
//    listNode.next = new ListNode(3);
//    listNode.next.next = new ListNode(2);
//    System.out.println(Arrays.toString(solution.reversePrint(listNode)));
//  }
//}


/**
 * 递归实现
 */
//public class Solution {
//  List<Integer> temp = new ArrayList<>();
//
//  public int[] reversePrint(ListNode head) {
//    recursion(head);
//    return temp.stream().mapToInt(Integer::valueOf).toArray();
//  }
//
//  private void recursion(ListNode head) {
//    if (head == null) {
//      return;
//    }
//    recursion(head.next);
//    temp.add(head.val);
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    ListNode listNode = new ListNode(1);
//    listNode.next = new ListNode(3);
//    listNode.next.next = new ListNode(2);
//    System.out.println(Arrays.toString(solution.reversePrint(listNode)));
//  }
//}


/**
 * 辅助栈实现
 */
public class Solution {
  public int[] reversePrint(ListNode head) {
    LinkedList<Integer> stack = new LinkedList<> ();
    while (head != null) {
      stack.addLast(head.val);
      head = head.next;
    }
    int[] res = new int[stack.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = stack.removeLast();
    }
    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(3);
    listNode.next.next = new ListNode(2);
    System.out.println(Arrays.toString(solution.reversePrint(listNode)));
  }
}
