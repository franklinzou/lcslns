/*
 * Plus One Linked List
 * Tag: Linked List
 */

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        // reverse original list
        ListNode revHead = reverse(head);
        // add one (calculate each digit, create ListNode and then append)
        int carrier = 1;
        ListNode cur = revHead, dummy = new ListNode(-1), pre = dummy;
        dummy.next = cur;
        // do in-place change
        while(cur != null){
            int sum = carrier + cur.val;
            cur.val = sum % 10;
            carrier = sum / 10;
            pre = cur;
            cur = cur.next;
        }
        // tail checking and add carrier if necessary
        if(carrier > 0) pre.next = new ListNode(carrier);        
        // reverse the result list
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1), cur = head;
        while(cur != null){
            ListNode nextCur = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = nextCur;
        }
        return dummy.next;
    }
}