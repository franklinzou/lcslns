/*
 * Rotate List
 * Tag: Linked List
 * Tag: Two Pointers
 */
import java.util.*;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if(len == 0) return null;
        k = k % len;
        // since we need length, we use basic method to find start of second part
        // we also record pre of cur, to make breaking later
        int preDis = len - k;
        ListNode dummy = new ListNode(-1), pre = dummy, cur = head, tail = dummy;
        dummy.next = head;
        for(int i = 1; i <= preDis; i++){
            pre = cur;
            cur = cur.next;
        }
        // break with the second part
        pre.next = null;
        // start appending from a non-tail node
        while(cur != null){
            ListNode nextCur = cur.next;
            cur.next = tail.next;
            tail.next = cur;
            tail = tail.next;
            cur = nextCur;
        }
        return dummy.next;
    }

    private int getLen(ListNode head){
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len ++;
        }
        return len;
    }
}