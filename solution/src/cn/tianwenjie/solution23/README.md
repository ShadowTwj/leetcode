### 合并K个排序链表(Merge k Sorted Lists)

#### 题目描述

合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

**示例:**

```
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
```

#### 题解

- 优先队列实现

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
        if (o1.val > o2.val) {
          return 1;
        } else if (o1.val < o2.val) {
          return -1;
        } else {
          return 0;
        }
      });
  
      for (ListNode node : lists) {
        if (node != null) {
          queue.add(node);
        }
      }
  
      ListNode result = new ListNode(0);
      ListNode p = result;
      while (!queue.isEmpty()) {
        p.next = queue.poll();
        p = p.next;
        if (p.next != null) {
          queue.add(p.next);
        }
      }
      return result.next;
  }
}
```

- 分治实现

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
```
