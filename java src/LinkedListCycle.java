/*
 * Linked List Cycle
 * Tag: Linked List
 * Tag: Two Pointers
 */
import java.util.*;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // check both fast and fast.next as we need to access both
        // after k*iteration, distance between slow and fast is k
        // therefore slow = fast appears after beginning before fast exceeds boundary <=> there exists cycle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        
        return false;
    }
}