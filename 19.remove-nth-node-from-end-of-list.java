/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) {
        	return head;
        }
        ListNode p = head, pPrevious = null, pi=head;
        int i = 0;
        while(i < n && pi != null) {
        	pi = pi.next;
        	i++;
        }
        if(i < n && pi == null) {
        	return head;
        } else if(i == n && pi == null) {
        	return head.next;
        }
        while(pi != null) {
        	pi = pi.next;
        	pPrevious = p;
        	p = p.next;
        }
        pPrevious.next = p.next;
        return head;
    }
}
