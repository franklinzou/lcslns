/*
 * Largest BST Subtree
 * Tag: Tree
 */
import java.util.*;

public class LargestBSTSubtree {
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        int [] stat = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        helper(root,stat);
        return res;
    }
    
    // TODO: complete analysis for null case
    // stat[0] is the minimum in tree from root, while stat[1] is the maximum
    private int helper(TreeNode root, int [] stat){
        if(root == null) return 0;
        // use Integer.MAX_VALUE and Integer.MIN_VALUE to cover null case
        int [] leftChildStat = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int [] rightChildStat = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int lCnt = helper(root.left, leftChildStat);
        int rCnt = helper(root.right, rightChildStat);
        int rootRes = -1;
        // if both left, right branch are BST and root value is also suitable, it becomes new BST
        if(lCnt >= 0 && rCnt >= 0 && root.val > leftChildStat[1] && root.val < rightChildStat[0]){
            rootRes = lCnt + rCnt + 1;
            stat[0] = root.left == null ? root.val : leftChildStat[0];
            stat[1] = root.right == null ? root.val : rightChildStat[1];
        }
        // update result possibly
        res = Math.max(res, rootRes);
        return rootRes;
    }
}