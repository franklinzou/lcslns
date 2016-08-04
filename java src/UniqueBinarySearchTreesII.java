/*
 * Unique Binary Search Trees II
 * Tag: Tree
 * Tag: Dynamic Programming
 */
import java.util.*;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTreesRange(1, n);
    }
    
    private List<TreeNode> generateTreesRange(int s, int e){
        List<TreeNode> res = new ArrayList<TreeNode>();
        // special null-list here:
        // TODO: consider more
        if(s > e) res.add(null);
        else{
            for(int i = s; i <= e; i++){
                List<TreeNode> lRes = generateTreesRange(s, i - 1);
                List<TreeNode> rRes = generateTreesRange(i + 1, e);
                for(int lInd = 0; lInd <= lRes.size() - 1; lInd ++)
                    for(int rInd = 0; rInd <= rRes.size() - 1; rInd ++){
                        TreeNode root = new TreeNode(i);
                        root.left = lRes.get(lInd);
                        root.right = rRes.get(rInd);
                        res.add(root);
                    }
            }
        }
        
        return res;
    }
}