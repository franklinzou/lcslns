/*
 * Symmetric Tree
 * Tag: Tree
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 */
import java.util.*;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // directly encode definition of a symmetric tree
        if(root == null) return true;
        // check availability of left and right
        return isSymmetricTwo(root.left, root.right);
    }
    
    private boolean isSymmetricTwo(TreeNode r1, TreeNode r2){
        // directly encode definition of two symmetric trees
        if(!(r1 == null && r2 == null) && !(r1 != null && r2 != null && r1.val == r2.val)) return false;
        if(r1 != null && (!isSymmetricTwo(r1.left, r2.right) || !isSymmetricTwo(r1.right, r2.left))) return false;
        return true;
    }
}