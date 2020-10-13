### 从尾到头打印链表

#### 题目描述
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例:**
```
输入：head = [1,3,2]
输出：[2,3,1]
```

**限制:**
`0 <= 链表长度 <= 10000`

#### 题解
- 反转list实现
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
  public int[] reversePrint(ListNode head) {
    List<Integer> temp = new ArrayList<Integer>();
    while (head != null) {
      temp.add(head.val);
      head = head.next;
    }
    int n = temp.size();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = temp.get(n - 1 - i);
    }
    return res;
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
  List<Integer> temp = new ArrayList<>();

  public int[] reversePrint(ListNode head) {
    recursion(head);
    return temp.stream().mapToInt(Integer::valueOf).toArray();
  }

  private void recursion(ListNode head) {
    if (head == null) {
      return;
    }
    recursion(head.next);
    temp.add(head.val);
  }
}
```

- 辅助栈实现
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
}
```
