/*
 * Merge Two Sorted Lists
 * Tag: Linked List
 */
import java.util.*;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur1 = l1, cur2 = l2, tail = dummy;
        
        // a direct variation of new appending list
        while(cur1 != null || cur2 != null){
            if(cur2 == null || (cur1 != null && cur1.val < cur2.val)){
                ListNode nextCur1 = cur1.next;
                tail.next = cur1;
                // guarantee new list ends at new tail
                tail = cur1;
                tail.next = null;
                cur1 = nextCur1;
            }
            else{
                ListNode nextCur2 = cur2.next;
                tail.next = cur2;
                tail = cur2;
                tail.next = null;
                cur2 = nextCur2;
            }
        }
        
        return dummy.next;
    }
}