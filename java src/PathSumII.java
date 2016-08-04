/*
 * Path Sum II
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res  = new ArrayList<List<Integer>>();
        List<Integer> preList = new ArrayList<Integer>();
        helper(res, preList, 0, root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> preList, int preSum, TreeNode root, int sum){
        if(root == null) return;
        preList.add(new Integer(root.val));
        int newSum = preSum + root.val;
        if(root.left == null && root.right == null){
            if(newSum == sum) res.add(new ArrayList<Integer>(preList));
        }
        else{
            helper(res, preList, newSum, root.left, sum);
            helper(res, preList, newSum, root.right, sum);
        }
        preList.remove(preList.size() - 1);
    }
}