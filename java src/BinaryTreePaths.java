/*
 * Binary Tree Paths
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        helper(res, builder, root);
        return res;
    }
    // a typical double-end dfs:
    private void helper(List<String> res, StringBuilder builder, TreeNode root){
        // fist nop end: stop execution and should act as if this branch does not exist
        if(root == null) return;
        int oriLen = builder.length();
        builder.append(root.val);
        // second summary end: stop execution and put path from root to it into result
        if(root.left == null && root.right == null)  res.add(builder.toString());
        else{
            builder.append("->");
            helper(res, builder, root.left);
            // we do not have to restore builder manually as it has been restored
            helper(res, builder, root.right);
        }
        // guarantee accumulation variable is restored after execution
        builder.setLength(oriLen);
    }
}