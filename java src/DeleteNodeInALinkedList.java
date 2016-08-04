/*
 * Delete Node in a Linked List
 * Tag: Linked List
 */
import java.util.*;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        while(true){
            cur.val = cur.next.val;
            if(cur.next.next == null){
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
    }
}