/*
 * Binary Tree Level Order Traversal II
 * Tag: Tree
 * Tag: Breadth-first Search
 */
import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer> l = new ArrayList<Integer>();
            int qSize = q.size();
            for(int i = 1; i <= qSize; i++){
                TreeNode tp = q.poll();
                l.add(tp.val);
                if(tp.left != null) q.offer(tp.left);
                if(tp.right != null) q.offer(tp.right);
            }
            // insert new list at the beginning
            res.add(0, l);
        }
        return res;        
    }
}