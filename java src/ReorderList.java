/*
 * Reorder List
 * Tag: Linked List
 */
import java.util.*;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        // slow.next is the beginning of following reverse, and there is no guarantee slow is 
        // not null. Therefore we do need a special check here.
        if(slow == null) return;
        ListNode mid = slow, cur = mid.next, revDummy = new ListNode(-1);
        // we break the first and second part for ending condition of final linking part
        mid.next = null;
        while(cur != null){
        	ListNode nextCur = cur.next;
        	cur.next = revDummy.next;
        	revDummy.next = cur;
        	cur = nextCur;
        }
        // link two parts with a new appending list. As first list is not shorter, we use it as a
        // ending condition
        ListNode resDummy = new ListNode(-1), tail = resDummy, cur1 = head, cur2 = revDummy.next;
        while(cur1 != null){
        	ListNode nextCur1 = cur1.next;
        	tail.next = cur1;
        	tail = tail.next;
        	tail.next = null;
        	cur1 = nextCur1;
        	// special check whether we can add from second list
        	if(cur2 != null){
        		ListNode nextCur2 = cur2.next;
        		tail.next = cur2;
        		tail = tail.next;
        		tail.next = null;
        		cur2 = nextCur2;
        	}
        }
    }
}