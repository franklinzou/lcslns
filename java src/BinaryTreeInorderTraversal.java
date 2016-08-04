/*
 * Binary Tree Inorder Traversal
 * Tag: Tree
 * Tag: Stack
 * Tag: Hash Table
 */
import java.util.*;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
        // recursive method (traversal DFS)
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
        */
        // iterative method
        // TODO: complete analysis
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true){
            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            else{
                if(s.empty()) break;
                TreeNode tp = s.pop();
                res.add(tp.val);
                cur = tp.right;
            }
        }
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode root){
        if(root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}