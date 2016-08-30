import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by alpb0130 on 2/2/16.
 */

public class ImplementStackUsingQueues {
    /*
    // Better solution. Time complexity is lower, but the run time is longer
    ArrayList<Queue<Integer>> lqueue = new ArrayList<Queue<Integer>>();
    int current;

    // Constructor
    public ImplementStackUsingQueues() {
        Queue<Integer> queue_1 = new LinkedList<Integer>();
        Queue<Integer> queue_2 = new LinkedList<Integer>();
        lqueue.add(queue_1);
        lqueue.add(queue_2);
        current = 0;
    }

    // Push element x onto stack.
    public void push(int x) {
        lqueue.get(current).offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (lqueue.get(current).size() > 1) {
            lqueue.get(1 - current).offer(lqueue.get(current).poll());
        }
        lqueue.get(current).poll();
        current = 1 - current;
    }

    // Get the top element.
    public int top() {
        int ret;
        while (lqueue.get(current).size() > 1) {
            lqueue.get(1 - current).offer(lqueue.get(current).poll());
        }
        ret = lqueue.get(current).poll();
        lqueue.get(1 - current).offer(ret);
        current = 1 - current;
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return lqueue.get(current).isEmpty();
    }

    */

    // My version. Using two queue. One to store, and another to do temporary storage.
    Queue<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack. O(1).
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack. O(n).
    public void pop() {
        Queue<Integer> queue_2 = new LinkedList<Integer>();
        while (queue.size() > 1) {
            queue_2.offer(queue.poll());
        }
        queue.poll();
        while (!queue_2.isEmpty()) {
            queue.offer(queue_2.poll());
        }
    }

    // Get the top element. O(n)
    public int top() {
        Queue<Integer> queue_2 = new LinkedList<Integer>();
        int ret;
        while (queue.size() > 1) {
            queue_2.offer(queue.poll());
        }
        ret = queue.poll();
        while (!queue_2.isEmpty()) {
            queue.offer(queue_2.poll());
        }
        queue.offer(ret);
        return ret;
    }

    // Return whether the stack is empty. O(1)
    public boolean empty() {
        return queue.isEmpty();
    }

    /*
    // Save time
    Queue<Integer> queue_1 = new LinkedList<Integer>();
    Queue<Integer> queue_2 = new LinkedList<Integer>();
    Queue<Integer> current = null;
    Queue<Integer> backup = null;

    // Constructor
    public MyStack() {
        current = queue_1;
        backup = queue_2;
    }
    // Push element x onto stack.
    public void push(int x) {
        current.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (current.size() > 1) {
            backup.offer(current.poll());
        }
        current.poll();
        Queue<Integer> temp = current;
        current = backup;
        backup = temp;
    }

    // Get the top element.
    public int top() {
        int ret;
        while (current.size() > 1) {
            backup.offer(current.poll());
        }
        ret = current.poll();
        backup.offer(ret);
        Queue<Integer> temp = current;
        current = backup;
        backup = temp;
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return current.isEmpty();
    }

    */
}
