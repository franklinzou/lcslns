/*
 * Self Crossing
 * Tag: Math
 */
import java.util.*;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
    	// TODO: full analysis
        // result when x.length = 0 is defined, so we do not treat it specially
        for(int i = 0; i <= x.length - 1; i ++){
            // Case 1 where arrow i goes across arrow i - 3
            if(i >= 3 && x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            // Case 2 where arrow i goes across arrow i - 4
            if(i >= 4 && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] == x[i - 3]) return true;
            // Case 3 where arrow goes across arrow i - 5
            if(i >= 5 && x[i - 1] + x[i - 5] >= x[i - 3] && x[i] + x[i - 4] >= x[i - 2]
            && x[i - 2] >= x[i - 4] && x[i - 1] <= x[i - 3]) return true;
        }
        return false;
    }
}