/*
 * Largest Number
 * Tag: Sort
 */
import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String [] strs = new String[n];
        for(int i = 0; i <= n - 1; i ++) strs[i] = String.valueOf(nums[i]);
        /*
         * Simple proof: X32Y3Z can be superceded by X332YZ
         */
        Comparator<String> cmp = new Comparator<String>() {
            // whether str1 is larger than str2
            public int compare(String str1, String str2) {
                String s1 = str1 + str2, s2 = str2 + str1;
                // if str2 > str1, str1 should be placed later
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strs, cmp);
        
        // special case where all nums are 0!!
        if(strs[0].charAt(0) == '0') return "0";
        StringBuilder resBld = new StringBuilder();
        for(String str : strs) resBld.append(str);
        
        return resBld.toString();
        
    }
};
