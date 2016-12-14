/*
 * Merge k Sorted Lists
 * Tag: Divide and Conquer
 * Tag: LinkedList
 * Tag: Heap
 */
import java.util.*;

class Pair implements Comparable<Pair>{
    int val;
    int group;
    public Pair(int val, int group) {
        this.val = val;
        this.group = group;
    }
    public int compareTo(Pair p) {
        return this.val - p.val;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        // divide and conquer method
        int n = lists.length;
        if(n == 0) return null;
        return mergeRangeLists(lists, 0, n - 1);
        */
        // heap based method
        int n = lists.length;
        ListNode [] heads = new ListNode[n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for(int i = 0; i <= n - 1; i ++) {
            heads[i] = lists[i];
            if(heads[i] != null) pq.offer(new Pair(heads[i].val, i));
        }
        ListNode dummy = new ListNode(-1), tail = dummy;
        while(!pq.isEmpty()) {
            Pair s = pq.poll();
            int sGroup = s.group;
            ListNode tar = heads[sGroup];
            heads[sGroup] = heads[sGroup].next;
            tar.next = null;
            tail.next = tar;
            tail = tail.next;
            if(heads[sGroup] != null) pq.offer(new Pair(heads[sGroup].val, sGroup));
        }
        
        return dummy.next;
    }
    
    private ListNode mergeRangeLists(ListNode[] lists, int s, int e) {
        if(s == e) return lists[s];
        int m = (s + e + 1) / 2;
        ListNode lList = mergeRangeLists(lists, s, m - 1);
        ListNode rList = mergeRangeLists(lists, m, e);
        return mergeTwoList(lList, rList);
    }
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        // Use array for efficient implementation and track position to move 
        // for the first or second list
        ListNode [] curs = {l1, l2};
        ListNode dummy = new ListNode(-1), tail = dummy;
        while(curs[0] != null || curs[1] != null) {
            int moveInd = -1;
            if(curs[0] == null) moveInd = 1;
            else if(curs[1] == null) moveInd = 0;
            else {
                if(curs[0].val < curs[1].val) moveInd = 0;
                else moveInd = 1;
            }
            ListNode addNode = curs[moveInd];
            curs[moveInd] = curs[moveInd].next;
            addNode.next = null;
            tail.next = addNode;
            tail = tail.next;
        }
        return dummy.next;
    }
}
