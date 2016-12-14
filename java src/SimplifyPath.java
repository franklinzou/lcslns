/*
 * Simplify Path
 * Tag: Stack
 * Tag: String
 */
import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String [] strs = path.split("/");
        Stack<String> s = new Stack<String>();
        for(String str : strs) {
            if(str.equals("") || str.equals(".")) continue;
            else if(str.equals("..")) {
                // Note: type: check before peek or pop
                if(!s.empty()) s.pop();
            }
            else s.push(str);
        }
        
        StringBuilder resBld = new StringBuilder();
        while(!s.empty()) {
            resBld.insert(0, s.peek());
            resBld.insert(0, "/");
            s.pop();
        }
        // special requirement of the problem
        return resBld.length() == 0 ? "/" : resBld.toString();
    }
}
