/*
 * Recover Binary Search Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root, pre = null;
        // misplaced nodes are first too big node and last too small node respectively
        TreeNode firBig = null, lastSmall = null;
        while(true){
            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            else{
                if(s.empty()) break;
                TreeNode tp = s.pop();
                if(pre != null && tp.val < pre.val){
                    if(firBig == null) firBig = pre;
                    lastSmall = tp;
                }
                pre = tp;
                cur = tp.right;
            }
        }
        // swap values of misplaced nodes
        int tmp = firBig.val;
        firBig.val = lastSmall.val;
        lastSmall.val = tmp;
    }
}