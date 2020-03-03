package cn.com.myproject.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * */
public class LeetCode225 {

    private Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public LeetCode225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size>1){
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
