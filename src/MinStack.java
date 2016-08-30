import java.util.Stack;

/**
 * Created by alpb0130 on 2/9/16.
 *
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min_stack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty()) {
            min_stack.push(x);
        } else {
            if (x < min_stack.peek()) {
                min_stack.push(x);
            } else {
                min_stack.push(min_stack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
