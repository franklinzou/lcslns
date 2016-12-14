/*
 * Group Shifted Strings
 * Tag: Hash Table
 * Tag: String
 */
import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mp = new HashMap<String, List<String>>();
        for(String str : strings) {
            String oriStr = null;
            if(str.length() == 0) oriStr = "";
            else{
                char [] chars = str.toCharArray();
                int dif = chars[0] - 'a';
                // NOTE: General: lossy conversion from int to char
                for(int i = 0; i <= chars.length - 1; i ++)
                    // get char dif-distance before, assume characters are placed repeatedly
                    chars[i] = (char)((chars[i] + 26 - dif) % 26);
                oriStr = new String(chars);
            }
            if(!mp.containsKey(oriStr)) mp.put(oriStr, new ArrayList<String>());
            mp.get(oriStr).add(str);
        }
        return new ArrayList<List<String>>(mp.values());
    }
}
