/*
 * Minimum Depth of Binary Tree
 * Tag: Tree
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 */
import java.util.*;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        /*
        // recursive approach
        if(root == null) return 0; // will only be reached when first root is null, special case
        
        // we guarantee next root will not be null, and this happens when result of minDepth(null) does not fit 
        // the calculation for the current root well
        if(root.left == null && root.right == null) return 1;
        if(root.left == null || root.right == null)
            return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        */
        // iterative approach
        // based on bfs idea, find the closest leaf node to the root
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int cnt = 0;
        // when root is non-empty, its leaf node must satisfy n.left == null && n.right == null
        while(!q.isEmpty()){
            cnt ++;
            int qSize = q.size();
            for(int i = 1; i <= qSize; i++){
                TreeNode tp = q.poll();
                if(tp.left == null && tp.right == null) return cnt;
                if(tp.left != null) q.offer(tp.left);
                if(tp.right != null) q.offer(tp.right);
            }
        }
        return -1;        
        
    }
}