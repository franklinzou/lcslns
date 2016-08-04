/*
 * Lowest Common Ancestor of a Binary Tree
 * Tag: Tree
 */
import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
    // typical multi-objective DFS:
    // return value is the p or q or its lowest common ancestor
    // use non-null return value to determine if p or q exists in branch
    
    // TODO: complete analysis
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode lRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rRes = lowestCommonAncestor(root.right, p, q);
        //there is only one node that contains p, q in both of its branches, which is the lowest ancestor
        if(lRes != null && rRes != null) return root;
        if(lRes != null) return lRes;
        if(rRes != null) return rRes;
        return null;
    }
}