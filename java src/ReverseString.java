/*
 * Tag: Two Pointers
 * Tag: String
 */
public class ReverseString {
    public String reverseString(String s) {
        int len = s.length();
        char [] arr = s.toCharArray();
        // guarantee s[S..l-1] and s[r+1..E] has the same length and already been swapped
        int l = 0, r = len - 1;
        while(l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return new String(arr);
    }
}