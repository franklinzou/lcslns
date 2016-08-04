/*
 * Validate Binary Search Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // basic idea: use basic property of inorder traversal of binary search tree
        // pre indicate the last TreeNode whose value should be put into array
        TreeNode cur = root, pre = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(true){
            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            else{
                if(s.empty()) break;
                TreeNode tp = s.pop();
                if(pre != null && pre.val >= tp.val) return false;
                pre = tp;
                cur = tp.right;
            }
        }
        return true;
    }
}