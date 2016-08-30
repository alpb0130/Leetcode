import java.util.Stack;

/**
 * Created by alpb0130 on 2/2/16.
 * <p>
 * 232. Implement Queue using Stacks
 * <p>
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push
 * to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long
 * as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or
 * peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> stack_1 = new Stack<Integer>();
    // Push element x to the back of queue. O(1).
    public void push(int x) {
        stack_1.push(x);
    }

    // Removes the element from in front of queue. O(n).
    public void pop() {
        Stack<Integer> stack_2 = new Stack<Integer>();
        while (stack_1.size() > 1) {
            stack_2.push(stack_1.pop());
        }
        stack_1.pop();
        while (!stack_2.isEmpty()) {
            stack_1.push(stack_2.pop());
        }
    }

    // Get the front element. O(n)
    public int peek() {
        Stack<Integer> stack_2 = new Stack<Integer>();
        int ret;
        while (stack_1.size() > 1) {
            stack_2.push(stack_1.pop());
        }
        ret = stack_1.peek();
        while (!stack_2.isEmpty()) {
            stack_1.push(stack_2.pop());
        }
        return ret;
    }

    // Return whether the queue is empty. O(1)
    public boolean empty() {
        return stack_1.isEmpty();
    }
}
