/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode mockedHead = new ListNode(0);
        mockedHead.next = head;
        ListNode p1 = head;
        ListNode lastEnd = mockedHead;
        while(p1 != null && p1.next != null) {
        	ListNode p2 = p1.next;
        	p1.next = p2.next;
        	lastEnd.next = p2;
        	p2.next = p1;
        	lastEnd = p1;
        	p1 = p1.next;
        }
        return mockedHead.next;
    }
}
