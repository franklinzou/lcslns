/*
 * Invert Binary Tree
 * Tag: Tree
 */
import java.util.*;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        // directly encode recursive operation
        // if subtrees are available, invert each, and then swap
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}