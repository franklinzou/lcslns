/*
 * Implement Queue using Stacks
 * Tag: Stack
 * Tag: Design
 */
import java.util.*;

public class MyQueue {
    public MyQueue() {
        prep = new Stack<Integer>();
        use = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        prep.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(use.empty()) transfer();
        use.pop();
    }

    // Get the front element.
    public int peek() {
        if(use.empty()) transfer();
        return use.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return prep.empty() && use.empty();
    }
    
    private void transfer() {
        while(!prep.empty()) {
            use.push(prep.peek());
            prep.pop();
        }        
    }
    
    private Stack<Integer> prep;
    private Stack<Integer> use;
}
