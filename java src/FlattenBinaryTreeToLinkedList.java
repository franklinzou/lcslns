/*
 * Flatten Binary Tree to Linked List
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        helper(root);
    }
    
    // return the last effective node after flattening tree starting at root
    private TreeNode helper(TreeNode root){
        TreeNode last = root, rightTmp = root.right;
        // flatten left branch and update last
        if(root.left != null){
            last = helper(root.left);
            root.right = root.left;
            root.left = null; // note here
        }
        // flatten original right branch, and update last
        if(rightTmp != null){
            TreeNode newLast = helper(rightTmp);
            last.right = rightTmp;
            last = newLast;
        }
        return last;
    }
}