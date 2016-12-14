/*
 * Convert Sorted List to Binary Search Tree
 * Tag: Depth-first Search
 * Tag: Linked List
 */
import java.util.*;

public class ConvertSortedListToBinarySearchTree {
    private ListNode currentNode;
    public TreeNode sortedListToBST(ListNode head) {
        // when head is null, result should be null; merged into general routine (calculating length)
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len ++;
            cur = cur.next;
        }
        currentNode = head;
        return helper(len);
        // TODO: slow-fast based method
    }
    
    // TODO: call by reference issue
    // build tree from currentNode with length len: direct bottom-up with ending method
    // Pointer Shift: we guarantee currentNode = currentNode + len when it's completed
    private TreeNode helper(int len) {
        if(len == 0) return null; // we do not move currentNode here as len is 0
        // NOTE: type: we guarantee lLen >= rLen to guarantee tree is balanced!
        int lLen = len / 2, rLen = len - lLen - 1;
        TreeNode lRes = helper(lLen);
        TreeNode res = new TreeNode(currentNode.val);
        res.left = lRes;
        currentNode = currentNode.next;
        res.right = helper(rLen);
        return res;
    }
}