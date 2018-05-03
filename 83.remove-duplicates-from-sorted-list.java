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
	ListNode pi = head.next, pa = head;
	while(pi != null) {
		if(pi.val != pa.val) {
			pa.next = pi;
			pa = pa.next;
		}
		pi = pi.next;
	}
	pa.next = null;
	return head;
    }
}
