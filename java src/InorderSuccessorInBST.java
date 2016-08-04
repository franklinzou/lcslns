/*
 * Inorder Successor in BST
 * Tag: Tree
 */
import java.util.*;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // it in fact returns the node with smallest number greater than p.val, otherwise, retun null
        // basic idea: sequence DFS with pruning
        // iterative method: 
        /*
        TreeNode cur = root, pre = null;
        while(cur != null){
            if(cur.val <= p.val) cur = cur.right;
            else{
                pre = cur;
                cur = cur.left;
            }
        }
        return pre;
        */
        // recursive method: 
        return helper(root, p, null);
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode bestPre){
        if(root == null) return bestPre;
        if(root.val <= p.val) return helper(root.right, p, bestPre); // we do not change bestPre here as root is not valid
        else return helper(root.left, p, root); // some tricks in replacing best Pre: TODO
    }
}