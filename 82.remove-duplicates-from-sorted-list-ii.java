/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
	ListNode virtualHead = new ListNode(0);
	virtualHead.next = head;
        ListNode prev = virtualHead, pCurrent = head, pi = head.next;
	while(pi != null) {
	    if(pi.val != pCurrent.val) {
		pCurrent.next = pi;
		prev = pCurrent;
		pCurrent = pCurrent.next;
		pi = pi.next;
	    }else{
		while(pi != null && pi.val == pCurrent.val) pi = pi.next;
		prev.next = pi;
		pCurrent = pi;
		if(pi != null) pi = pi.next;
	    }
	}
	if(pCurrent != null) pCurrent.next = null;
	return virtualHead.next;
    }
}
