/*
 * Intersection of Two Linked Lists
 * Tag: Linked List
 */
import java.util.*;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        int len1 = getLen(headA), len2 = getLen(headB);
        // adjust until remaining parts of listA and listB have the same length
        if(len1 > len2) cur1 = adjust(cur1, len1 - len2);
        else cur2 = adjust(cur2, len2 - len1);
        ListNode res = null;
        while(cur1 != null){
            if(cur1 == cur2){
                res = cur1;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        return res;
    }
    
    private int getLen(ListNode head){
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len ++;
            cur = cur.next;
        }
        return len;
    }
    
    private ListNode adjust(ListNode head, int cnt){
        ListNode res = head;
        while(cnt > 0){
            res = res.next;
            cnt --;
        }
        return res;
    }
}