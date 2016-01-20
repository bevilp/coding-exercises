package ctci.chapter3StacksAndQueues;

import java.util.Stack;

/**
 * q4
 *
 * @since 2015-11-18
 */
public class q4 {
//TODO
    /*
    * Queue via stack
    *
    * Implement a MyQueue class which implements a queue using two stacks.
    * */

    public static class MyQueue {

        Stack<String> addingStack = new Stack<>();

        Stack<String> removingStack = new Stack<>();

        public boolean isEmpty() {
            return addingStack.isEmpty() && removingStack.isEmpty();
        }

        public void add(String data) {
            addingStack.add(data);
        }

        public String remove() {
            if (removingStack.isEmpty()) {
                while (!addingStack.isEmpty()) {
                    removingStack.push(addingStack.pop());
                }
            }
            return removingStack.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        for (int i = 0; i < 10; i++) {
            queue.add("" + i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }
}
