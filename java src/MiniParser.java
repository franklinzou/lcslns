/*
 * Mini Parser
 * Tag: Stack
 * Tag: String
 */
import java.util.*;

public class MiniParser {
    public NestedInteger deserialize(String s) {
        
        Stack<NestedInteger> st = new Stack<NestedInteger>();
        int len = s.length();

        st.push(new NestedInteger());
        for(int i = 0; i <= len - 1; i ++) {
            char c = s.charAt(i);
            // Note: general: extract integer from string (including negative integers)
            if(c == '-' || Character.isDigit(c)) {
                int numS = i;
                while(i + 1 <= len - 1 && Character.isDigit(s.charAt(i + 1))) 
                    i ++;
                int val = Integer.parseInt(s.substring(numS, i + 1));
                st.push(new NestedInteger(val));
            }
            else if(c == '[') st.push(null); // range beginning mark
            else if(c == ']') {
                NestedInteger res = new NestedInteger();
                List<NestedInteger> resL = new ArrayList<NestedInteger>();
                while(st.peek() != null) {
                    resL.add(st.peek());
                    st.pop();
                }
                st.pop(); // clear beginning mark
                for(int j = resL.size() - 1; j >= 0; j--) res.add(resL.get(j));
                st.push(res);
            }
        }
        return st.peek();
    }
}
