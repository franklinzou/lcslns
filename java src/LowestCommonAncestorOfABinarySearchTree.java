/*
 * Lowest Common Ancestor of a Binary Search Tree
 * Tag: Tree
 */
import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {
    // LCA is the first node such that:
    // (root.val - p.val) * (root.val - q.val) <= 0 (NOTE equality case)
    // use scope-changing method, discard the impossible region
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val - p.val) * (root.val - q.val) <= 0) return root;
        TreeNode nextRoot = p.val < root.val ? root.left : root.right;
        return lowestCommonAncestor(nextRoot, p, q);
    }
}