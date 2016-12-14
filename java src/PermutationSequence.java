/*
 * Permutation Sequence
 * Tag: Backtracking
 * Tag: Math
 */
import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int factor = 1;
        // get (n - 1)!
        for(int i = 2; i <= n - 1; i++) factor *= i;
        boolean [] used = new boolean[n + 1];
        StringBuilder resBld = new StringBuilder();
        // the number of permutations to hide
        int hide = k - 1;
        for(int i = n - 1; i >= 0; i --){
            // Decide index of unused number by hide and hide increment (factor)
        	int ind = hide / factor, next = 0;
        	hide = hide % factor;
        	for(int j = 1; j <= n; j ++){
        		if(!used[j]){
        			if(next == ind){
        				resBld.append(j);
        				used[j] = true;
        				break;
        			}
        			next ++;
        		}
        	}
        	// Special judgement here to avoid runtime error
        	if(i != 0) factor /= i;
        }

        return resBld.toString();
    }
}