/*
 * Partition List
 * Tag: Linked List
 * Tag: Two Pointers
 */
import java.util.*;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        // dummy head, tail of two new lists
        ListNode tail1 = dummy1, tail2 = dummy2, cur = head;
        while(cur != null){
            // cache cur for next iteration
            ListNode nextCur = cur.next;
            if(cur.val < x){
                tail1.next = cur;
                tail1 = cur;
            }
            else{
                tail2.next = cur;
                tail2 = cur;
            }
            // break end of tail to meet the guarantee
            cur.next = null;
            cur = nextCur;
        }
        // connect two lists (tail1 and real head of new_list2)
        tail1.next = dummy2.next;
        return dummy1.next;
    }
}