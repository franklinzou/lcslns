/*
 * Maximum Depth of Binary Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        /*
        // recursive based method
        if(root == null) return 0; // will only be reached when first root is null, special case
        
        // we guarantee next root will not be null, and this happens when result of maxDepth(null) does not fit 
        // the calculation for the current root well
        if(root.left == null && root.right == null) return 1;
        if(root.left == null || root.right == null)
            return 1 + (root.left == null ? maxDepth(root.right) : maxDepth(root.left));
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));    
        */
        
        // iterative based method (bfs): like layer traversal, count the layer of final group of nodes
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int res = 0; // the layer count of all previous nodes before iteration
        while(!q.isEmpty()){
            res ++;
            int qSize = q.size();
            for(int i = 1; i <= qSize; i++){
                TreeNode tp = q.poll();
                if(tp.left != null) q.offer(tp.left);
                if(tp.right != null) q.offer(tp.right);
            }
        }
        return res;
    }
}