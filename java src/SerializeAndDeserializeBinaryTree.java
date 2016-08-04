/*
 * Serialize and Deserialize Binary Tree
 * Tag: Tree
 * Tag: Design
 */
import java.util.*;

public class SerializeAndDeserializeBinaryTree {
	// TODO: complete analysis
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        StringBuilder resBuilder = new StringBuilder(String.valueOf(root.val));
        resBuilder.append("," + serialize(root.left));
        resBuilder.append("," + serialize(root.right));
        
        return resBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] vals = data.split(",");
        int [] ind = {0};
        return helper(vals, ind);
    }
    
    // use ind to update next position to read from ind, build tree from vals starting at ind[0]
    private TreeNode helper(String [] vals, int[] ind){
        // also use ind[0] to monitor position to read from inside the process
        String rootVal = vals[ind[0] ++]; // add ind by 1
        if(rootVal.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootVal)); 
        
        root.left = helper(vals, ind);
        root.right = helper(vals, ind);
        return root;
    }
}