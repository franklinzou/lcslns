/*
 * Binary Tree Right Side View
 * Tag: Tree
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 */
import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        /*
        // dfs based method
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root, 0);
        return res;
        */
        
        // bfs based method
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 1; i <= qSize; i++){
                TreeNode tp = q.poll();
                if(i == qSize) res.add(tp.val);
                if(tp.left != null) q.offer(tp.left);
                if(tp.right != null) q.offer(tp.right);
            }
        }
        return res;
    }
    
    // one-end dfs, use null to end branching
    private void helper(List<Integer> res, TreeNode root, int level){
        if(root == null) return;
        if(res.size() == level) res.add(root.val); // check if root is the rightmost node on current level
        // guarantee any node A right to node B (in a more right path) will be accessed before
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }
}