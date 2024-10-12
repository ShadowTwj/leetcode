package cn.tianwenjie.solution150;

import java.util.Stack;

/**
 * 栈实现
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num = stack.pop();
                    stack.push(stack.pop() / num);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] params = new String[] {"2", "1", "+", "3", "*"};
        String[] params1 = new String[] {"4", "13", "5", "/", "+"};
        String[] params2 = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(params));
        System.out.println(solution.evalRPN(params1));
        System.out.println(solution.evalRPN(params2));
    }
}
