/*
 * Find Leaves of Binary Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root);
        return res;
    }
    // if not ends at nop end, return 0; else, return its maximum leaf height + 1
    private int helper(List<List<Integer>> res, TreeNode root){
        if(root == null) return 0; //operation at nop end, its effect will be dismissed as max is used by parent
        // distance from root towards deepest leaf node in left branch and right branch
        int lHeight = helper(res, root.left), rHeight = helper(res, root.right);
        int rootHeight = Math.max(lHeight, rHeight);
        // when res.size() == rootHeight, then root is the first node at this left height. it is not possible
        // to have res.size() < rootHeight because of its children
        if(res.size() == rootHeight) res.add(new ArrayList<Integer>());
        res.get(rootHeight).add(root.val);
        return rootHeight + 1;
    }
}