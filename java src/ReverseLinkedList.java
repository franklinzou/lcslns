/*
 * Reverse Linked List
 * Tag: Linked List
 */
import java.util.*;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        // we guarantee List[dummy..E] - dummy = REV(List[head..cur] - cur) before iteration
        while(cur != null){
            // cache the next cur as cur.next is changed afterwards
            ListNode nextCur = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = nextCur;
        }
        return dummy.next;
    }
}