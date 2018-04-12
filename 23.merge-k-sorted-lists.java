/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
        	return null;
        }
        mergeKlists(lists, lists.length);
        return lists[0];
    }

    private void mergeKlists(ListNode[] lists, int n) {
    	if(n == 1) {
    		return;
    	}
    	for(int i=0; i<n/2; i++) {
    		lists[i] = mergeTwoLists(lists[i], lists[n-i-1]);
    	}
    	mergeKlists(lists, n%2 == 0 ? n/2 : n/2+1);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
        	return l2;
        } else if(l2 == null) {
        	return l1;
        }
        ListNode result = new ListNode(0);
        ListNode p = result;
        while(l1 != null && l2 != null) {
        	if(l1.val > l2.val) {
        		p.next = l2;
        		p = l2;
        		l2 = l2.next;
        	} else {
        		p.next = l1;
        		p = l1;
        		l1 = l1.next;
        	}
        }
        if(l1 == null && l2 != null) {
        	p.next = l2;
        } else if(l1 != null && l2 == null) {
        	p.next = l1;
        }
        return result.next;
    }
}
