### 最小栈(Min Stack)

#### 题目描述
设计一个支持`push` ，`pop` ，`top` 操作，并能在常数时间内检索到最小元素的栈。
- `push(x)` —— 将元素 x 推入栈中。
- `pop()` —— 删除栈顶的元素。
- `top()` —— 获取栈顶元素。
- `getMin()` —— 检索栈中的最小元素。


**示例:**
```
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

**说明：**
- `pop`、`top` 和 `getMin` 操作总是在 非空栈 上调用。

#### 题解
- 两个辅助栈实现
```java
class MinStack {
  LinkedList<Integer> stack1, stack2;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }

  public void push(int x) {
    stack1.addLast(x);
    Integer last = stack2.peekLast();
    if (last == null || last > x) {
      stack2.addLast(x);
    } else {
      stack2.addLast(last);
    }
  }

  public void pop() {
    stack1.removeLast();
    stack2.removeLast();
  }

  public int top() {
    return stack1.peekLast();
  }

  public int getMin() {
    return stack2.peekLast();
  }
}
```
- 不使用额外空间,保存差值
```java
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

  public int getMin() {
    return minValue;
  }
}
```
