/*
 * Binary Tree Zigzag Level Order Traversal
 * Tag: Tree
 * Tag: Breadth-first Search
 * Tag: Stack
 */
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int ind = 0; // the index of layer for next iteration
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer> l = new ArrayList<Integer>();
            int qSize = q.size();
            for(int i = 1; i <= qSize; i++){
                TreeNode tp = q.poll();
                if(ind % 2 == 0) l.add(tp.val);
                else l.add(0, tp.val);
                if(tp.left != null) q.offer(tp.left);
                if(tp.right != null) q.offer(tp.right);
            }
            res.add(l);
            ind ++;
        }
        return res;        
    }
}