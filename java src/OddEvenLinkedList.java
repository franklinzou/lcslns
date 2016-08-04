/*
 * Odd Even Linked List
 * Tag: Linked List
 */
import java.util.*;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1), evenDummy = new ListNode(-1);
        ListNode cur = head, oddTail = oddDummy, evenTail = evenDummy;
        int step = 1;
        // direct variation of new appending list problem
        while(cur != null){
            ListNode nextCur = cur.next;
            // if step is odd
            if(step % 2 == 1){
                oddTail.next = cur;
                oddTail = cur;
            }
            else{
                evenTail.next = cur;
                evenTail = cur;
            }
            cur.next = null;
            cur = nextCur;
            step ++;
        }
        oddTail.next = evenDummy.next;
        return oddDummy.next;
    }
}