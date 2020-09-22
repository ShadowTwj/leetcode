package cn.tianwenjie.solution21;

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
 * 递归实现
 */
//public class Solution {
//  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    if (l1 == null) {
//      return l2;
//    }
//    if (l2 == null) {
//      return l1;
//    }
//    if (l1.val < l2.val) {
//      l1.next = mergeTwoLists(l1.next, l2);
//      return l1;
//    } else {
//      l2.next = mergeTwoLists(l1, l2.next);
//      return l2;
//    }
//  }
//
//  public static void main(String[] args) {
//    ListNode node = new ListNode(1);
//    node.next = new ListNode(2);
//    node.next.next = new ListNode(4);
//
//    ListNode node1 = new ListNode(1);
//    node1.next = new ListNode(3);
//    node1.next.next = new ListNode(4);
//
//    Solution solution = new Solution();
//    System.out.println(solution.mergeTwoLists(node, node1));
//  }
//}


/**
 * 迭代实现
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(-1);

    ListNode temp = result;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }

    temp.next = l1 == null ? l2 : l1;

    return result.next;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(4);

    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(3);
    node1.next.next = new ListNode(4);

    Solution solution = new Solution();
    System.out.println(solution.mergeTwoLists(node, node1));
  }
}
