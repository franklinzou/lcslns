/*
 * Same Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // directly encode definition of same tree
        /*
         * roots both not exist or both exist and share the same value AND
         * both lefts are not available, or both are available and the same AND
         * both rights are not available, or both are available and the same
         */
        if(!(p == null && q == null) && !(p != null && q != null && p.val == q.val) ) return false;
        if(p != null && (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))) return false;
        return true;
    }
}