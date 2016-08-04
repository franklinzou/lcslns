/*
 * Lowest Common Ancestor of a Binary Search Tree
 * Tag: Tree
 */
import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {
    // similar to sequence DFS, multi-objective DFS
    // TODO: more analysis
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val - p.val) * (root.val - q.val) <= 0) return root;
        TreeNode nextRoot = p.val < root.val ? root.left : root.right;
        return lowestCommonAncestor(nextRoot, p, q);
    }
}