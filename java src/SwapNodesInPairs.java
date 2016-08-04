/*
 * Swap Nodes in Pairs
 * Tag: Linked List
 */
import java.util.*;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), tail = dummy, cur = head, oddCache = null;
        boolean odd = true;
        while(cur != null){
            ListNode nextCur = cur.next;
            // cache node if it appears at a odd position
            if(odd) oddCache = cur;
            else{
                tail.next = cur;
                tail.next.next = oddCache;
                tail = tail.next.next;
                tail.next = null;
            }
            cur = nextCur;
            odd = !odd;
        }
        // if original list end at a odd position, add oddCache at the result tail
        if(!odd){
            tail.next = oddCache;
            tail.next.next = null;
        }
        return dummy.next;
    }
}