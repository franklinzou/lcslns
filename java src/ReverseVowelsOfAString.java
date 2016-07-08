public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int len = s.length();
        int l = 0, r = len - 1;
        //we guarantee s[S..l-1] and s[r+1..E] contains the same number of vowels and have been swapped
        char[] cArr = s.toCharArray();
        while(l < r){
            if(!isVowel(cArr[l])) l++;
            else if(!isVowel(cArr[r])) r--;
            else{
                char tmp = s.charAt(l);
                cArr[l] = cArr[r];
                cArr[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(cArr);        
    }

    
    boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
         c == 'A' ||c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }   
}