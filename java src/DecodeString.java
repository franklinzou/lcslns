/*
 * Decode String
 * Tag: Depth-first Search
 * Tag: Stack
 */
import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> st = new Stack<StringBuilder>();
        Stack<Integer> cnts = new Stack<Integer>();
        
        int len = s.length();
        // put new result base at beginning of range, get result base and put it as new 
        // operand of upper layer result base
        st.push(new StringBuilder());
        for(int i = 0; i <= len - 1; i ++) {
            int intS = i;
            if(Character.isDigit(s.charAt(i))) {
                // Note: type: extract number from string iteration
                while(i + 1 <= len - 1 && Character.isDigit(s.charAt(i)))
                    i ++;
                cnts.push(Integer.parseInt(s.substring(intS, i + 1)));
            }
            else if(s.charAt(i) == '[') st.push(new StringBuilder());
            else if(s.charAt(i) == ']') {
                int cnt = cnts.peek(); cnts.pop();
                String cont = st.peek().toString();
                for(int j = 1; j <= cnt - 1; j ++) st.peek().append(cont);
                StringBuilder top = st.peek(); st.pop();
                st.peek().append(top.toString());
            }
            else st.peek().append(s.charAt(i));
        }
        
        return st.peek().toString();
    }
}
