/*
 * Convert Sorted Array to Binary Search Tree
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRange(nums, 0, nums.length - 1);
    }
    
    // typical children DFS
    private TreeNode sortedArrayToBSTRange(int [] nums, int s, int e){
        if(s > e) return null;
        int mid = (s + e + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // sorting array guarantee any number left to mid is smaller than nums[mid], and numbers at right is larger
        root.left = sortedArrayToBSTRange(nums, s, mid - 1);
        root.right = sortedArrayToBSTRange(nums, mid + 1, e);
        return root;
    }
}