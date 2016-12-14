/*
 * Read N Characters Given Read4 II - Call multiple times
 * Tag: String
 */
import java.util.*;

public class ReadNCharactersGivenRead4II {
    private int readPos = 0, readCnt = 0;
    private char [] tmp = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int rem = n, ind = 0;
        do{
            // continue reading previous tmp storage
            for(; readPos <= readCnt - 1 && rem > 0; readPos ++) {
                buf[ind ++] = tmp[readPos];
                rem --;
            }
            // if we still need to read, first read to tmp buffer and reset copy position
            // we need to judge rem, because if previous copy is terminated by rem, we should not do another read
            if(rem > 0) {
                readCnt = read4(tmp);
                readPos = 0;
            }
        }while(readCnt > 0 && rem > 0);
        
        return ind;
    }
}
