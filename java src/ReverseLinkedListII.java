/*
 * Reverse Linked List II
 * Tag: Linked List
 */
import java.util.*;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        // distance from head to cur
        int step = 1;
        while(step < m){
            pre = pre.next;
            cur = cur.next;
            step ++;
        }
        // dummy head of new reverse list and reverseTail indicates the first node to be inserted after dummy head
        ListNode reverseTail = cur, reverseListDummy = pre;
        // !! break from new list dummy to meet the guarantee: new_list[dummy..cur] - dummy = rev[list[reverse_head..cur] - cur]
        reverseListDummy.next = null;
        while(step <= n){
            ListNode nextCur = cur.next;
            cur.next = reverseListDummy.next;
            reverseListDummy.next = cur;
            cur = nextCur;
            step ++;
        }
        // connect reversed list to the remaining part
        reverseTail.next = cur;
        return dummy.next;
    }
}