/*
 * Linked List Cycle II
 * Tag: Linked List
 * Tag: Two Pointers
 */
import java.util.*;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean meet = false;
        /*
         * Define cycle handler with length l_1 and cycle with length l_2. Assume travel length of slow is l_3
         * when they meet for the first time. We have 2*l_3 - l_3 = l_3 = k*l_2 (as slow and fast pointers meet).
         * Suppose l_4 = (l_3 - l_1) % l_2, l_5 = l_2 - l_4. We have l_4 + l_1 = k_1 * l_2 (k_1 >= 1), and 
         * l_4 + l_5 = l_2, hence l_1 - l_5 = (k_1 - 1)*l_2. Now put slow back at head and let both move one each step.
         * After l_5 iterations, fast is at beginning of cycle and slow is (k_1 - 1)*l_2 far from it. Therefore they will
         * finally meet again at cycle beginning.
         */
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                meet = true;
                break;
            }
        }
        if(!meet) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}