/*
 * Bulls and Cows
 * Tag: Hash Table
 */
import java.util.*;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        /*
         * Common count of a number i: both secret and guess exist that number of number i
         * Super count of a number i: both secret and guess exist number of number i at the same positions
         * bull = \sum_{I} sCnt(I), cow = \sum_{I} cCnt(I) - sCnt(I) 
         */
        int len = secret.length(), bull = 0, cow = 0;
        int [] secCnt = new int[10], gueCnt = new int[10];
        for(int i = 0; i <= len - 1; i ++){
            int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
            if(s == g) bull ++;
            else{
                secCnt[s] ++;
                gueCnt[g] ++;
            }
        }
        for(int i = 0; i <= 9; i ++) cow += Math.min(secCnt[i], gueCnt[i]);
        return bull + "A" + cow + "B";
    }
}
