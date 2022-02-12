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
// TODO: 2021/1/14 未完成
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

        ListNode con = prev, tail = cur;

        ListNode nextTemp;
        for (int i = 0; i < n - m; i++) {
            nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(solution.reverseBetween(node, 2, 4));
    }
}
