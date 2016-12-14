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
        // Basic idea: use stack to simulate system. Use root to simulate input parameter for
        // recursion method
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true){
            if(cur != null){
                s.push(cur); // save invocation context
                cur = cur.left; // update parameter for next invocation
            }
            else{
                // when cur == null, retrieve last invocation context
                if(s.empty()) break; // if no stored context, algorithm ends
                TreeNode tp = s.pop();
                res.add(tp.val);
                cur = tp.right; // update parameter for next invocation
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