/*
 * Sort List
 * Tag: Linked List
 * Tag: Sort
 */
import java.util.*;

public class SortList {
	// merge-sort method
	public ListNode sortList(ListNode head){
		// merge sort
		return mergeSort(head);
		// TODO: quick-sort
		
	}

	private ListNode mergeSort(ListNode head){
		//stop partition when the element in the list is 0 or 1
		if(head == null || head.next == null) return head;
		ListNode dummy = new ListNode(-1), pre = dummy, slow = head, fast = head, secHead = null;
		dummy.next = head;
		while(fast != null && fast.next != null){
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		secHead = slow;
		pre.next = null;
		System.out.println(head.val + "," + (secHead == null ? "null" : secHead.val));
		return merge(mergeSort(head), mergeSort(secHead));
	}

	private ListNode merge(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(-1), cur1 = l1, cur2 = l2, tail = dummy;
		while(cur1 != null || cur2 != null){
			if(cur2 == null || (cur1 != null && cur1.val < cur2.val)){
				ListNode nextCur1 = cur1.next;
				cur1.next = null;
				tail.next = cur1;
				tail = tail.next;
				cur1 = nextCur1;
			}
			else{
				ListNode nextCur2 = cur2.next;
				cur2.next = null;
				tail.next = cur2;
				tail = tail.next;
				cur2 = nextCur2;
			}
		}
		return dummy.next;
	}
}