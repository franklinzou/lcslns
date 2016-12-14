/*
 * Basic Calculator II
 * Tag: String
 */
import java.util.*;

public class BasicCalculatorII {
    public int calculate(String s) {
        s = s + '#';
        Stack<Integer> opds = new Stack<Integer>();
        Stack<Character> oprs = new Stack<Character>();
        
        int len = s.length();
        for(int i = 0; i <= len - 1; i ++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            else if(Character.isDigit(c)) {
                int numS = i;
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))) i ++;
                opds.push(Integer.parseInt(s.substring(numS, i + 1)));
            }
            else {
                while(!oprs.empty() && getPri(oprs.peek()) >= getPri(c)) {
                    char opr = oprs.peek(); oprs.pop();
                    int op2 = opds.peek(); opds.pop();
                    int op1 = opds.peek(); opds.pop();
                    opds.push(eva(op1, op2, opr));
                }
                oprs.push(c);
            }
        }
        return opds.peek();
    }
    
    private int eva(int op1, int op2, char opr) {
        int res = -1;
        switch(opr) {
            case '+': res = op1 + op2; break;
            case '-': res = op1 - op2; break;
            case '*': res = op1 * op2; break;
            case '/': res = op1 / op2; break;
        }
        return res;
    }
    
    private int getPri(char opr) {
        switch(opr) {
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
        }
        return -1;
    }
}
