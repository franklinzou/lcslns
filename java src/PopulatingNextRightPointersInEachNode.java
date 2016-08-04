/*
 * Populating Next Right Pointers in Each Node
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        // current root for indicates the next root to deal with, pre is its parent
        // layerFirst indicates the first node in the current layer
        TreeLinkNode cur = root.left, layerFirst = root.left, pre = root;
        while(cur != null){
            if(cur == pre.left) cur.next = pre.right;
            else{
                pre = pre.next;
                if(pre != null) cur.next = pre.left;
            }
            if(cur.next != null) cur = cur.next;
            else{
                cur = layerFirst.left;
                pre = layerFirst;
                layerFirst = cur;
            }
        }
    }
}