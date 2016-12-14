/*
 * Nested List Weight Sum II
 * Tag: Depth-first Search
 */
import java.util.*;

public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);
        return getSum(nestedList, depth);
    }
    // get sum of nestedList with depth
    // nestedList is not NULL, direct up-down with branching control
    private int getSum(List<NestedInteger> nestedList, int depth){
        int res = 0;
        for(NestedInteger nInt : nestedList){
            if(nInt.isInteger()) res += nInt.getInteger() * depth;
            else res += getSum(nInt.getList(), depth - 1);
        }
        return res;
    }
    
    // get depth of list nestedList
    private int getDepth(List<NestedInteger> nestedList) {
        int maxChildDepth = 0;
        for(NestedInteger nInt : nestedList){
            if(!nInt.isInteger()) maxChildDepth = Math.max(maxChildDepth, getDepth(nInt.getList()));
        }
        return maxChildDepth + 1;
    }
}