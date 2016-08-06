/*
 * Line Reflection
 * Tag: Math
 * Tag: Hash Table
 */
import java.util.*;

public class LineReflection {
    public boolean isReflected(int[][] points) {
        //undefined input
        if(points.length == 0) return true;
        
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        Set<Integer> s = new HashSet<Integer>();
        for(int [] point : points){
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            // use hash code to uniquely represent an point (in fact an integer pair)
            s.add(Arrays.hashCode(point));
        }
        // TODO: full logical analysis
        int expSum = minX + maxX;
        for(int [] point : points)
            //check whether its counterpart by mid exists
            if(!s.contains(Arrays.hashCode(new int []{expSum - point[0], point[1]})))
                return false;
                
        return true;
    }
}