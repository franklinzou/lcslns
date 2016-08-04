/*
 * Binary Search Tree Iterator
 * Tag: Tree
 * Tag: Stack
 * Tag: Design
 */
import java.util.*;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> s;
    private TreeNode cur;
    public BinarySearchTreeIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	// iterate till we need to check stack
        while(cur != null){
            s.push(cur);
            cur = cur.left;
        }
        return !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
    	// extract from stack and change cur
    	TreeNode tp = s.pop();
    	cur = tp.right;
    	return tp.val;
    }
}