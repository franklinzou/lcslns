/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Tag: Tree
 * Tag: Array
 * Tag: Depth-first Search
 */
import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildTreeRange(preorder, 0, inorder, 0, len);
    }
    
    // build tree with preorder[preS..preS + len - 1] and inorder[inS..inS + len - 1]
    public TreeNode buildTreeRange(int[] preorder, int preS, int[] inorder, int inS, int len){
        if(len == 0) return null;
        TreeNode root = new TreeNode(preorder[preS]);
        int rootPos = inS, leftLen = -1;
        // locate position of root in inorder and calculate length of left tree
        while(inorder[rootPos] != preorder[preS]) rootPos++;
        leftLen = rootPos - inS;
        root.left = buildTreeRange(preorder, preS + 1, inorder, inS, leftLen);
        root.right = buildTreeRange(preorder, preS + 1 + leftLen, inorder, rootPos + 1, len - 1 - leftLen);
        return root;
    }
}