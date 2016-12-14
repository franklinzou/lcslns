/*
 * Read N Characters Given Read4
 * Tag: String
 */
import java.util.*;

public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char [] tmp = new char[4];
        int readCnt = -1, ind = 0, rem = n;
        do{
            // read from file
            readCnt = read4(tmp);
            // copy from tmp buffer while not finish copying and rem is larger than 0 
            for(int i = 0; i <= readCnt - 1 && rem > 0; i ++){
                buf[ind ++] = tmp[i];
                rem --;
            }
        }while(readCnt == 4 && rem > 0); // stop if at end of file or rem is 0
        
        return ind;
    }
}
