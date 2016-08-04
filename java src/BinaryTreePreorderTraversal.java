/*
 * Binary Tree Preorder Traversal
 * Tag: Tree
 * Tag: Stack
 */
import java.util.*;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        /*
        // recursive solution (traversal dfs)
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
        */
        
        // iterative based method (can either use stack or queue)
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.empty()){
            TreeNode tp = s.pop();
            // guarantee the access sequence: root->left->right
            res.add(tp.val);
            if(tp.right != null) s.push(tp.right);
            if(tp.left != null) s.push(tp.left);
        }
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root){
        if(root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}