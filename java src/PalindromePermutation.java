/*
 * Palindrome Permutation
 * Tag: Hash Table
 */
import java.util.*;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        /*
         * At most one character in s has odd occurence <=> s is palindrome
         * Use set to check whether the occurance is even
         */
        Set<Character> st = new HashSet<Character>();
        for(char c : s.toCharArray())
            if(!st.add(c)) st.remove(c);
        return st.size() <= 1;    
    }
}
