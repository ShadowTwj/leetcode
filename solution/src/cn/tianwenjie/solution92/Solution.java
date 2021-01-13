package cn.tianwenjie.solution92;


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
public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) {
      return null;
    }

    ListNode cur = head, prev = null;
    for (int i = 1; i < m; i++) {
      prev = cur;
      cur = cur.next;
    }

    ListNode con = prev, tail = null;
    for (int i = 0; i < n - m; i++) {

    }

    return head;
  }
}
