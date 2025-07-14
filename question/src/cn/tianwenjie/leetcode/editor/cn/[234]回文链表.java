/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数目在范围[1, 10⁵] 内
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 2080 👎 0
 */

package cn.tianwenjie.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(head));
    }

//leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//    /**
//     * 将值复制到数组中
//     */
//    public boolean isPalindrome(ListNode head) {
//            List<Integer> data = new ArrayList<>();
//
//            while (head != null) {
//                data.add(head.val);
//                head = head.next;
//            }
//
//            boolean flag = true;
//
//            for (int i = 0; i < data.size() / 2; i++) {
//                if (!data.get(i).equals(data.get(data.size() - i - 1))) {
//                    flag = false;
//                }
//            }
//
//            return flag;
//        }
//    }


    class Solution {
        /**
         * 反转链表法
         */
        public boolean isPalindrome(ListNode head) {
            ListNode midListNode = getMidListNode(head);
            ListNode reverseListNode = reverseList(midListNode);

            while (reverseListNode != null) {
                if (head.val != reverseListNode.val) {
                    return false;
                }
                head = head.next;
                reverseListNode = reverseListNode.next;
            }

            return true;
        }

        /**
         * 获取中间节点
         */
        public ListNode getMidListNode(ListNode head) {
            //慢指针一次1步
            ListNode slow = head;
            //快指针一次两步
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        /**
         * 反转链表
         */
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
//leetcode submit region end(Prohibit modification and deletion)

}