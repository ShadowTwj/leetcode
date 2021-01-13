package cn.tianwenjie.solution206;


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
 * 迭代实现
 */
//public class Solution {
//  public ListNode reverseList(ListNode head) {
//    ListNode pre = null, cur = head;
//    while (cur != null) {
//      ListNode nextNode = cur.next;
//      cur.next = pre;
//      pre = cur;
//      cur = nextNode;
//    }
//
//    return pre;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    ListNode node = new ListNode(1);
//    node.next = new ListNode(2);
//    node.next.next = new ListNode(3);
//    node.next.next.next = new ListNode(4);
//    node.next.next.next.next = new ListNode(5);
//    System.out.println(solution.reverseList(node));
//  }
//}

/**
 * 递归实现
 */
public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode last = reverseList(head.next);
    head.next.next = head;
    head.next = null;

    return last;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    System.out.println(solution.reverseList(node));
  }
}
