/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode v1 = new ListNode(0);
        ListNode v2 = new ListNode(0);
        ListNode p = head, p1 = v1, p2 = v2;
        while(p != null) {
        	if(p.val < x) {
        		p1.next = p;
        		p1 = p1.next;
        	} else {
        		p2.next = p;
        		p2 = p2.next;
        	}
        	p = p.next;
        }
        p1.next = v2.next;
        p2.next = null;
        return v1.next;
    }
}
