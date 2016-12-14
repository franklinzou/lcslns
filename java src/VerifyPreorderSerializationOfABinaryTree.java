/*
 * Verify Preorder Serialization of a Binary Tree
 * Tag: Stack
 */
import java.util.*;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        // basic idea: use stack to simulate the state of recursive calls
        Stack<Integer> cnts = new Stack<Integer>();
        cnts.push(0); // set new call in stack before invocation
        String [] strs = preorder.split(",");
        for(String str : strs) {
            if(cnts.empty()) return false;
            // pop stack elements at return statement
            if(str.equals("#")) {
                cnts.pop();
                while(!cnts.empty() && cnts.peek() == 1)
                    cnts.pop();
                // reach unfinished parent call, change its state and invoke next child call
                if(!cnts.empty()) {
                    cnts.pop();
                    cnts.push(1);
                    cnts.push(0);
                }
            }
            // invoke first child call
            else cnts.push(0);
        }
        
        return cnts.empty();
    }
}
