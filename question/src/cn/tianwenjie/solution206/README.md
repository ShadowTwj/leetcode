### 反转链表(Reverse Linked List)

#### 题目描述

反转一个单链表。

示例:

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

#### 题解

- 迭代实现

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode pre = null, cur = head;
    while (cur != null) {
      ListNode nextNode = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nextNode;
    }

    return pre;
  }
}
```

- 递归实现

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
}
```
