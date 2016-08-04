/*
 * Power of Four
 * Tag: Bit Manipulation
 */
import java.util.*;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        // Note: priority of == and & (== is superior)
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}