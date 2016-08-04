/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Tag: Tree
 * Tag: Array
 * Tag: Depth-first Search
 */
import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return buildTreeRange(inorder, 0, postorder, 0, len);
    }
    // build tree with inorder[inS..inS + len - 1] and postorder[postS..postS + len - 1]
    public TreeNode buildTreeRange(int [] inorder, int inS, int [] postorder, int postS, int len){
        if(len == 0) return null;
        int rootVal = postorder[postS + len - 1];
        TreeNode root = new TreeNode(rootVal);
        // locate root value in inorder and length of left branch
        int rootPos = inS, leftLen = -1;
        while(inorder[rootPos] != rootVal) rootPos ++;
        leftLen = rootPos - inS;
        root.left = buildTreeRange(inorder, inS, postorder, postS, leftLen);
        root.right = buildTreeRange(inorder, rootPos + 1, postorder, postS + leftLen, len - 1 - leftLen);
        return root;
    }
}