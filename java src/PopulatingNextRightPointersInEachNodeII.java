/*
 * Populating Next Right Pointers in Each Node II
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode pre = root, preEff = null, layerFirst = null;
        // we iterate over pre in its layer (previous layer relative to working layer), and
        // check for whether it has effective children (not-null), when pre is null, then
        // we has arrived the end of previous layer. If layerFirst is not null, we move to next
        // layer; otherwise, we stop the loop.
        while(true){
            if(pre == null){
                if(layerFirst == null) break;
                else{
                    // move to the next layer
                    pre = layerFirst;
                    preEff = null;
                    layerFirst = null;
                }
            }
            else{
                // check whether left and right children are effective
                if(pre.left != null){
                    // if there is no previous effective node in the current node, set layerFirst
                    if(preEff == null) layerFirst = pre.left;
                    // otherwise, set next pointer of 
                    else preEff.next = pre.left;
                    preEff = pre.left;
                }
                if(pre.right != null){
                    if(preEff == null) layerFirst = pre.right;
                    else preEff.next = pre.right;
                    preEff = pre.right;
                }
                // move pre pointer
                pre = pre.next;
            }
        }
    }
}