/*
 * Remove Nth Node From End of List
 * Tag: Linked List
 * Tag: Two Pointers
 */
import java.util.*;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode forwd = head, back = null, pre = null;
        // the step between head and forw(ar)d before iteration
        int step = 0;
        
        // to guarantee distance between back and forwd is n, therefore back is the target when forwd is null        
        while(step < n){
        	forwd = forwd.next;
        	step++;
        }
        back = head;
        pre = dummy;
        
        while(true){
            if(forwd == null){
                pre.next = back.next;
                break;
            }
            forwd = forwd.next;
            back = back.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}