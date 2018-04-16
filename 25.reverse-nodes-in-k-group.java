/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) {
        	return head;
        }
        ListNode mockedHead = new ListNode(0);
        mockedHead.next = head;
        int i = 0;
        ListNode lastEnd = mockedHead;
        ListNode p = head;
        ListNode phead=null, ptail=null;
        while(p != null) {
        	if(i % k == 0) {
        		phead = p;
        		p = p.next;
        	} else if(i % k == k-1) {
        		ptail = p;
        		lastEnd = reverseK(phead, ptail, lastEnd);
        		p = lastEnd.next;
        	} else {
	        	p = p.next;
        	}
        	i++;
        }
        return mockedHead.next;
    }

    private ListNode reverseK(ListNode head, ListNode tail, ListNode lastEnd) {
    	ListNode p = head;
    	while(p != tail) {
    		ListNode tmp = p;
    		p = p.next;
    		lastEnd.next = p;
    		tmp.next = tail.next;
    		tail.next = tmp;
    	}
    	return head;
    }
}
