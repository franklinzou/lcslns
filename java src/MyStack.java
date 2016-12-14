/*
 * Implement Stack using Queues
 * Tag: Stack
 * Tag: Design
 */
import java.util.*;

public class MyStack {
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        // rotate elements before x
        int qSize = q.size();
        for(int i = 1; i <= qSize - 1; i ++) q.offer(q.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
    
    private Queue<Integer> q;
}
