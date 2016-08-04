/*
 * Binary Tree Maximum Path Sum
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getLeftRightMax(root);
        return res;
    }
    // get maximal result when AT MOST one branch is accessed through root
    private int getLeftRightMax(TreeNode root){
        if(root == null) return 0;
        int lRes = getLeftRightMax(root.left), rRes = getLeftRightMax(root.right);
        // the maximal result when AT MOST one branch is accessed through root
        int singleRes = Math.max(Math.max(lRes, rRes), 0) + root.val;
        // the maximal result when two branches are accessed through root
        int doubleRes = lRes + rRes + root.val;
        res = Math.max(res, Math.max(singleRes, doubleRes));
        return singleRes;
    }
}