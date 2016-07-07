/*
 * Tag: Two Pointers
 * Tag: String
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int len = s.length();
        int l = 0, r = len - 1;
        //we guarantee the s[s..l-1] and s[r+1..e] is valid palindrome
        //before next iteration with l, r
        while(l < r){
            if(!isValid(s.charAt(l))) l++;
            else if(!isValid(s.charAt(r))) r--;
            else if(s.charAt(l) != s.charAt(r)) return false;
            else{
                l++;
                r--;
            }
        }
        
        return true;
    }
    
    public boolean isValid(char c){
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}