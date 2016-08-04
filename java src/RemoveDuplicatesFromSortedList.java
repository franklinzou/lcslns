/*
 * Remove Duplicates from Sorted List
 * Tag: Linked List
 */
import java.util.*;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode resTail = dummy, cur = head;
        boolean first = true;
        while(cur != null){
            ListNode nextCur = cur.next;
            if(first || cur.val != resTail.val){
                resTail.next = cur;
                cur.next = null;
                resTail = resTail.next;
            }
            first = false;
            cur = nextCur;
        }
        return dummy.next;
    }
}