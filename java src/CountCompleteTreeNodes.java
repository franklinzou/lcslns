/*
 * Count Complete Tree Nodes
 * Tag: Tree
 * Tag: Binary Search
 */
import java.util.*;

public class CountCompleteTreeNodes {
    // TODO: time complexity analysis
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = 0, rightHeight = 0;
        // when left height and right height are the same, we can simply calculate
        // node count with height
        for(TreeNode cur = root; cur != null; cur = cur.left) leftHeight++;
        for(TreeNode cur = root; cur != null; cur = cur.right) rightHeight++;
        if(leftHeight == rightHeight) return (2 << (leftHeight - 1)) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
}