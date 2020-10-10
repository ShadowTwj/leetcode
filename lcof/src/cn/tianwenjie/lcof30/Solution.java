package cn.tianwenjie.lcof30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 两个辅助栈实现
 */
//class MinStack {
//  LinkedList<Integer> stack1, stack2;
//
//  /**
//   * initialize your data structure here.
//   */
//  public MinStack() {
//    stack1 = new LinkedList<>();
//    stack2 = new LinkedList<>();
//  }
//
//  public void push(int x) {
//    stack1.addLast(x);
//    Integer last = stack2.peekLast();
//    if (last == null || last > x) {
//      stack2.addLast(x);
//    } else {
//      stack2.addLast(last);
//    }
//  }
//
//  public void pop() {
//    stack1.removeLast();
//    stack2.removeLast();
//  }
//
//  public int top() {
//    return stack1.peekLast();
//  }
//
//  public int min() {
//    return stack2.peekLast();
//  }
//}

/**
 * 不使用额外空间,保存差值
 */
class MinStack {
  List<Long> stack;
  int minValue;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack = new ArrayList<>();
    minValue = -1;
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.add(0L);
      minValue = x;
    } else {
      stack.add((long) x - minValue);
      minValue = Math.min(x, minValue);
    }
  }

  public void pop() {
    long diff = stack.remove(stack.size() - 1);
    //判断是否需要修改minValue
    if (diff < 0) {
      minValue = (int) (minValue - diff);
    }
  }

  public int top() {
    long diff = stack.get(stack.size() - 1);
    return diff < 0 ? minValue : (int) (minValue + diff);
  }

  public int min() {
    return minValue;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class Solution {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.min());
  }
}
