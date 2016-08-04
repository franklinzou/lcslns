/*
 * Insertion Sort List
 * Tag: LinkedList
 * Tag: Sort
 */

public class InsertionSortList{
	public ListNode insertionSortList(ListNode head){
		ListNode dummy = new ListNode(-1), cur = head;
		// dynamically find insertion place in the new insertion list
		while(head != null){
			// try to examine insertion between itPre and itCur
			ListNode itPre = dummy, itCur = dummy.next, nextCur = cur.next;
			while(itCur != null && cur.val > itCur.val){
				itPre = itCur;
				itCur = itCur.next;
			}

			cur.next = itPre.next;
			itPre.next = cur;
			cur = cur.next;
		}
		return dummy.next;
	}
}