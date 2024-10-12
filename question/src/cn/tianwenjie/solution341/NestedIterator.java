package cn.tianwenjie.solution341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> {
    LinkedList<NestedInteger> data;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.data = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return data.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!data.isEmpty() && !data.peekFirst().isInteger()) {
            List<NestedInteger> integerList = this.data.removeFirst().getList();
            for (int i = integerList.size() - 1; i >= 0; i--) {
                this.data.addFirst(integerList.get(i));
            }
        }
        return !data.isEmpty();
    }
}
