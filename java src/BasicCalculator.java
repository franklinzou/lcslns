/*
 * Basic Calculator
 * Tag: Stack
 * Tag: Math
 */
import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        s = "(" + s + ")"; // to empty stack at the end
        Stack<Integer> opds = new Stack<Integer>();
        Stack<Character> oprs = new Stack<Character>();
        
        int len = s.length();
        for(int i = 0; i <= len - 1; i ++) {
            if(s.charAt(i) == ' ') continue;
            else if(Character.isDigit(s.charAt(i))) {
                int numS = i;
                while(i + 1 <= len - 1 && Character.isDigit(s.charAt(i + 1)))
                    i ++;
                opds.push(Integer.parseInt(s.substring(numS, i + 1)));
            }
            else if(s.charAt(i) == ')'){
                // evaluate expression within "()"
                while(oprs.peek() != '(') {
                    char opr = oprs.peek(); oprs.pop();
                    int op2 = opds.peek(); opds.pop();
                    int op1 = opds.peek(); opds.pop();
                    opds.push(eva(op1, op2, opr));
                }
                oprs.pop(); // remove "("
            }
            else oprs.push(s.charAt(i)); // +, -, (
        }
        return opds.peek();
    }
    
    private int eva(int op1, int op2, char opr) {
        int res = -1;
        switch(opr) {
            case '+': res = op1 + op2; break;
            case '-': res = op1 - op2; break;
        }
        return res;
    }
}
