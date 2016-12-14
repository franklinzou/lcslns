/*
 * Min Stack
 * Tag: Stack
 * Tag: Design
 */
import java.util.*;

public class MinStack {

    /** initialize your data structure here. */
    public MinStack() {
        geneS = new Stack<Integer>();
        minS = new Stack<Integer>();
    }
    
    public void push(int x) {
        geneS.push(x);
        // Note:type: peek() or pop() from empty stack
        // Note equality here!!
        if(minS.empty() || minS.peek() >= x) minS.push(x);
    }
    
    public void pop() {
        if(geneS.peek() - minS.peek() == 0) minS.pop();
        geneS.pop();
    }
    
    public int top() {
        return geneS.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
    
    // minS.peek() is guaranteed to be minimal value of elements in geneS
    private Stack<Integer> geneS;
    private Stack<Integer> minS;
}
