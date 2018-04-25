/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
        	return head;
        }
        int n = 0;
        ListNode p = head;
        while(p != null) {
        	n++;
        	p = p.next;
        }
        k = k%n;
        if(k == 0) {
        	return head;
        }
        ListNode mockedHead = new ListNode(0);
        mockedHead.next = head;
        p = mockedHead;
        ListNode ped = head;
        int distance = 1;
        while(ped.next != null) {
        	ped = ped.next;
        	if(distance < k) {
        		distance++;
        	} else {
        		p = p.next;
        	}
        }
        mockedHead.next = p.next;
        ped.next = head;
        p.next = null;
        return mockedHead.next;
    }
}
