### 环形链表(Linked List Cycle)

#### 题目描述

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

**示例1:**

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

![image](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例2:**

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

![image](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例3:**

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

![image](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

**进阶:**
你能用 O(1)（即，常量）内存解决此问题吗？

#### 题解

- Set实现

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
      Set<ListNode> set = new HashSet<>();
      while (head != null) {
        if (set.contains(head)) {
          return true;
        } else {
          set.add(head);
        }
        head = head.next;
      }
      return false;
    }
}
```

- 快慢指针实现

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
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
}
```
