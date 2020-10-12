package cn.tianwenjie.solution141;

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}


/**
 * Set实现
 */
//public class Solution {
//  public boolean hasCycle(ListNode head) {
//    Set<ListNode> set = new HashSet<>();
//    while (head != null) {
//      if (set.contains(head)) {
//        return true;
//      } else {
//        set.add(head);
//      }
//      head = head.next;
//    }
//    return false;
//  }
//
//  public static void main(String[] args) {
//    ListNode listNode = new ListNode(3);
//    listNode.next = new ListNode(2);
//    listNode.next.next = new ListNode(0);
//    listNode.next.next.next = new ListNode(-4);
//    listNode.next.next.next.next = listNode.next;
//    Solution solution = new Solution();
//    System.out.println(solution.hasCycle(listNode));
//  }
//}


/**
 * 快慢指针实现
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    return true;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(3);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(0);
    listNode.next.next.next = new ListNode(-4);
    listNode.next.next.next.next = listNode.next;
    Solution solution = new Solution();
    System.out.println(solution.hasCycle(listNode));
  }
}
