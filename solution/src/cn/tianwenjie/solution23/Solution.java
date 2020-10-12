package cn.tianwenjie.solution23;

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
 * 优先队列实现
 */
//public class Solution {
//  public ListNode mergeKLists(ListNode[] lists) {
//    if (lists == null || lists.length == 0) {
//      return null;
//    }
//    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
//      if (o1.val > o2.val) {
//        return 1;
//      } else if (o1.val < o2.val) {
//        return -1;
//      } else {
//        return 0;
//      }
//    });
//
//    for (ListNode node : lists) {
//      if (node != null) {
//        queue.add(node);
//      }
//    }
//
//    ListNode result = new ListNode(0);
//    ListNode p = result;
//    while (!queue.isEmpty()) {
//      p.next = queue.poll();
//      p = p.next;
//      if (p.next != null) {
//        queue.add(p.next);
//      }
//    }
//    return result.next;
//  }
//
//  public static void main(String[] args) {
//    ListNode node = new ListNode(1);
//    node.next = new ListNode(4);
//    node.next.next = new ListNode(5);
//
//    ListNode node1 = new ListNode(1);
//    node1.next = new ListNode(3);
//    node1.next.next = new ListNode(4);
//
//    ListNode node2 = new ListNode(2);
//    node2.next = new ListNode(6);
//
//    ListNode[] list = new ListNode[] {node, node1, node2};
//    Solution solution = new Solution();
//    System.out.println(solution.mergeKLists(list));
//  }
//}


/**
 * 分治实现
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }
    int pointer = (start + end) / 2;
    ListNode l1 = merge(lists, start, pointer);
    ListNode l2 = merge(lists, pointer + 1, end);
    return mergeTwoListNode(l1, l2);
  }

  /**
   * 合并两个有序链表
   */
  private ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoListNode(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListNode(l1, l2.next);
      return l2;
    }
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(4);
    node.next.next = new ListNode(5);

    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(3);
    node1.next.next = new ListNode(4);

    ListNode node2 = new ListNode(2);
    node2.next = new ListNode(6);

    ListNode[] list = new ListNode[] {node, node1, node2};
    Solution solution = new Solution();
    System.out.println(solution.mergeKLists(list));
  }
}
