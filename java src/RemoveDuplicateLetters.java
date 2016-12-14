/*
 * Remove Duplicate Letters
 * Tag: Stack
 * Tag: Greedy
 */
import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int [] cnts = new int[26];
        boolean [] used = new boolean[26];
        for(char c : s.toCharArray()) cnts[c - 'a'] ++;
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray()) {
            // Note: count should get deduced even used[c - 'a'] = true
            cnts[c - 'a'] --;            
            // can prove there exists better valid string without c
            if(used[c - 'a']) continue;
            // can prove there exists better valid string without st.peek()
            while(!st.empty() && st.peek() > c && cnts[st.peek() - 'a'] > 0) {
                used[st.peek() - 'a'] = false;                
                st.pop();
            }
            st.push(c);
            used[c - 'a'] = true;
        }
        
        StringBuilder resBld = new StringBuilder();
        while(!st.empty()) {
            resBld.insert(0, st.peek());
            st.pop();
        }
        
        return resBld.toString();
    }
}
