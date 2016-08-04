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
        // TODO: analysis
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while(!s.empty()){
            TreeNode tp = s.peek();
            if((tp.left == null && tp.right == null) || (pre != null && (tp.left == pre || tp.right == pre))){
                s.pop();
                res.add(tp.val);
                pre = tp;
            }
            else{
                if(tp.right != null) s.push(tp.right);
                if(tp.left != null) s.push(tp.left);
            }
        }
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root){
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}