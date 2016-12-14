/*
 * Valid Parentheses
 * Tag: Stack
 * Tag: String
 */
import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> validPair = new HashMap<Character, Character>();
        validPair.put('(', ')');
        validPair.put('[', ']');
        validPair.put('{', '}');
        Stack<Character> st = new Stack<Character>();
        
        // Judge whether ranges interleave with each other
        for(char c : s.toCharArray()) {
        	// range beginning
            if(c == '(' || c == '[' || c == '{') st.push(c);
            // range end
            else {
                if(st.empty() || c != validPair.get(st.peek())) return false;
                st.pop();
            }
        }
        
        return st.empty();
    }
}
