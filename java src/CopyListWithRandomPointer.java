/*
 * Copy List with Random Pointer
 * Tag: Hash Table
 * Tag: Linked List
 */
import java.util.*;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        // create a new one-one mapping between original nodes and new nodes such that mapping pairs have 
        // exact label and children of original nodes are the same as that of new nodes after mapping
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head, dummy = new RandomListNode(-1), tail = dummy;
        
        while(cur != null) {
            tail.next = new RandomListNode(cur.label);
            tail = tail.next;
            map.put(cur, tail);
            cur = cur.next;
        }
        RandomListNode oriCur = head, newCur = dummy.next;
        while(oriCur != null) {
            newCur.random = map.get(oriCur.random);
            oriCur = oriCur.next;
            newCur = newCur.next;
        }
        return dummy.next;        
    }
}
