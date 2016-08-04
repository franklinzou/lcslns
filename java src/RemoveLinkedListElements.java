/*
 * Remove Linked List Elements
 * Tag: Linked List
 */
import java.util.*;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null){
            if(cur.val == val) pre.next = cur.next;
            else pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}