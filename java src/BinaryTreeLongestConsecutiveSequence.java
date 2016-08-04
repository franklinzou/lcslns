/*
 * Binary Tree Longest Consecutive Sequence
 * Tag: Tree
 */
import java.util.*;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return bestThroughRoot(root, null, 0, 0);
    }
    // one-end: use end as summary node, there is no reason to rule out a non-leaf path result
    // return best length for consecutive sequences going through root, preLen for length of consecutive sequence
    // till parent node, preBest for best length in the path till parent node
    private int bestThroughRoot(TreeNode root, TreeNode par, int preLen, int preBest){
        if(root == null) return preBest;
        int newLen = (par != null && root.val == par.val + 1) ? preLen + 1 : 1;
        int newBest = Math.max(preBest, newLen);
        return Math.max(bestThroughRoot(root.left, root, newLen, newBest), 
            bestThroughRoot(root.right, root, newLen, newBest));
    }
}