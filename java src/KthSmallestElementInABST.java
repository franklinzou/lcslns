/*
 * Kth Smallest Element in a BST
 * Tag: Tree
 * Tag: Binary Search
 */
import java.util.*;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        /*
        // basic O(n) method: use k-th inorder traversal node: O(k)
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        int cnt = 0, res = -1; // number of nodes put so far
        while(true){
            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode tp = s.pop();
                if(cnt == k - 1){
                    res = tp.val;
                    break;
                }
                cnt ++;
                cur = tp.right;
            }
        }
        return res;
        */
        // TODO: optimal time complexity solution
    	return -1;
    }
}