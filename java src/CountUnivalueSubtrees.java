/*
 * Count Univalue Subtrees
 * Tag: Tree
 */
import java.util.*;

public class CountUnivalueSubtrees {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return count;
    }
    
    // guarantee root is not null-typical full branching dfs, null root is nop end here
    // count the uni-value subtrees for trees starting at root and its subtrees, return if all tree is uni-value
    private boolean helper(TreeNode root){
        boolean lRes = root.left == null ? true : helper(root.left) && root.val == root.left.val;
        boolean rRes = root.right == null ? true : helper(root.right) && root.val == root.right.val;
        if(lRes && rRes) count ++;
        return lRes && rRes;
    }
}