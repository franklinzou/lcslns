/*
 * Binary Tree Upside Down
 * Tag: Tree
 */
import java.util.*;

public class BinaryTreeUpsideDown {
	// children DFS: after dealing with left branch, do with root, right child
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        // the real root of three node group here
        TreeNode curRoot = root.left;
        if(curRoot == null) return root; // leftmost node, the root of final tree
        
        TreeNode res = upsideDownBinaryTree(curRoot);
        // now when left branch of root is finished, change the three node group
        // here we ONLY guarantee the correctness three node group and its left branch: worked area method!!
        curRoot.left = root.right;
        curRoot.right = root;
        root.left = root.right = null; // note that!
        return res;
    }
}