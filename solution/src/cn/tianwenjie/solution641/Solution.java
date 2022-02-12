package cn.tianwenjie.solution641;

class MyCircularDeque {

    int[] data;
    int capacity;
    int head = 0;
    int tail = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        data = new int[capacity];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        head = (head - 1 + capacity) % capacity;
        data[head] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + capacity) % capacity];

    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

public class Solution {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));              // 返回 true
        System.out.println(circularDeque.insertLast(2));              // 返回 true
        System.out.println(circularDeque.insertFront(3));              // 返回 true
        System.out.println(circularDeque.insertFront(4));              // 已经满了，返回 false
        System.out.println(circularDeque.getRear());        // 返回 2
        System.out.println(circularDeque.isFull());              // 返回 true
        System.out.println(circularDeque.deleteLast());            // 返回 true
        System.out.println(circularDeque.insertFront(4));              // 返回 true
        System.out.println(circularDeque.getFront());      // 返回 4
    }
}
