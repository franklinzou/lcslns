/*
 * Balanced Binary Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }
    
    // -1 if not balanced, or the height of the tree rooted at root
    public int depth(TreeNode root){
        if(root == null) return 0;
        // directly encode the definition of NON-balanced tree
        int l = depth(root.left), r = depth(root.right);
        if(l < 0 || r < 0 || Math.abs(l - r) > 1) return -1;
        // directly encode the definition of tree height (including root = null case)
        return Math.max(l, r) + 1;
    }
}