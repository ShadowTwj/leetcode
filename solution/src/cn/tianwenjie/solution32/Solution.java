package cn.tianwenjie.solution32;

/**
 * 栈实现
 */
//public class Solution {
//  public int longestValidParentheses(String s) {
//    Stack<Integer> stack = new Stack<>();
//
//    int max = 0;
//    stack.push(-1);
//    for (int i = 0; i < s.length(); i++) {
//      char c = s.charAt(i);
//      if ('(' == c) {
//        stack.push(i);
//      } else {
//        stack.pop();
//        if (stack.isEmpty()) {
//          stack.push(i);
//        } else {
//          max = Math.max(max, i - stack.peek());
//        }
//      }
//    }
//    return max;
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.longestValidParentheses("(()"));
//    System.out.println(solution.longestValidParentheses("()"));
//    System.out.println(solution.longestValidParentheses("("));
//    System.out.println(solution.longestValidParentheses(")()())"));
//    System.out.println(solution.longestValidParentheses("()(()"));
//    System.out.println(solution.longestValidParentheses("()()"));
//  }
//}


/**
 * 动态规划实现
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses("()"));
        System.out.println(solution.longestValidParentheses("("));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses("()()"));
        System.out.println(solution.longestValidParentheses("())"));
    }
}
