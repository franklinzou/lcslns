/*
 * Add Two Numbers
 * Tag: Linked List
 * Tag: Math
 */
import java.util.*;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), tail = dummy, cur1 = l1, cur2 = l2;
        int carrier = 0;
        // we use carrier as a special condition in while loop for possible calculation of extra final digit
        while(cur1 != null || cur2 != null || carrier != 0){
            int n1 = 0, n2 = 0;
            if(cur1 != null){
                n1 = cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                n2 = cur2.val;
                cur2 = cur2.next;
            }
            int sum = n1 + n2 + carrier;
            carrier = sum / 10;
            ListNode resNode = new ListNode(sum % 10);
            // append the result node because result is also in reverse order
            tail.next = resNode;
            tail = tail.next;
            tail.next = null;
        }
        
        return dummy.next;
    }
}