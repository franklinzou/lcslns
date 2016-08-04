/*
 * Closest Binary Search Tree Value
 * Tag: Tree
 * Tag: Binary Search
 */
import java.util.*;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        return closetValueSeq(root, null, target);
    }
    
    public int closetValueSeq(TreeNode root, TreeNode preBest, double target){
        if(root == null) return preBest.val; // preBest should not be null when null is reached
        TreeNode newBest = preBest == null || Math.abs(root.val - target) < Math.abs(preBest.val - target) ? root : preBest;
        // here we only go to one branch, as if root.val > target, there is no better result (than root.val) from nodes at right branch
        TreeNode selectedChild = root.val > target ? root.left : root.right;
        return closetValueSeq(selectedChild, newBest, target);
    }
}