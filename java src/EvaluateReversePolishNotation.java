/*
 * Evaluate Reverse Polish Notation
 * Tag: Stack
 */
import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ops = new Stack<Integer>();
        for(String token : tokens) {
            char pos1 = token.charAt(0);
            // Note: type: judge number from String
            if((pos1 >= '0' && pos1 <= '9') || (pos1 == '-' && token.length() > 1))
                ops.push(Integer.valueOf(token));
            else {
                // Note: type: order issue
                int op2 = ops.peek(); ops.pop();
                int op1 = ops.peek(); ops.pop();
                ops.push(eva(op1, op2, token.charAt(0)));
            }
        }
        
        return ops.peek();
    }
    
    private int eva(int op1, int op2, char opr) {
        int res = 0;
        switch(opr) {
            case '+': res = op1 + op2; break;
            case '-': res = op1 - op2; break;
            case '*': res = op1 * op2; break;
            case '/': res = op1 / op2; break;
        }
        
        return res;
    }
}
