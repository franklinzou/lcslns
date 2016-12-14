/*
 * Binary Tree Postorder Traversal
 * Tag: Tree
 * Tag: Stack
 */
import java.util.*;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        /*
        // recursive method (traversal DFS)
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
        */
        // iterative based method: similar to preorder traversal
        // Actually use stack to simulate recursive method sec_helper. Use first judgement
        // to judge whether the context runs to res.add(root.val);
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while(!s.empty()){
            TreeNode tp = s.peek();
            if((tp.left == null && tp.right == null) || (pre != null && (tp.left == pre || tp.right == pre))){
                res.add(tp.val);
                s.pop(); // remove context in stack when completing
                pre = tp;
            }
            else{
                if(tp.right != null) s.push(tp.right); // put new context in stack
                if(tp.left != null) s.push(tp.left); // put new context in stack
            }
        }
        return res;
        /*
        // effective recursive method for iterative method
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        sec_helper(res, root);
        return res;
        */
    }
    
    private void helper(List<Integer> res, TreeNode root){
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    private void sec_helper(List<Integer> res, TreeNode root){
        if(root.left != null) sec_helper(res, root.left);
        if(root.right != null) sec_helper(res, root.right);
        res.add(root.val);
    }
}